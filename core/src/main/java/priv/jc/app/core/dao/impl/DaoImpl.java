/**
 * 
 */
package priv.jc.app.core.dao.impl;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ParameterMode;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import freemarker.cache.TemplateLoader;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import priv.jc.app.core.dao.Dao;
import priv.jc.app.core.domain.Domain;

/**
 * @author Jacky
 *
 */
public abstract class DaoImpl<T extends Domain> extends HibernateDaoSupport implements Dao<T> {
	private final Log logger = LogFactory.getLog(getClass());

	private Class<T> clazz;

	private Configuration config;

	private TemplateLoader templateLoader;

	public Log getLogger() {
		return logger;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	public void setConfig(Configuration config) {
		this.config = config;
	}

	public void setTemplateLoader(TemplateLoader templateLoader) {
		this.templateLoader = templateLoader;
	}

	public Serializable save(T entity) throws DataAccessException {
		return getHibernateTemplate().save(entity);
	}

	public void save(List<T> entity) throws DataAccessException {
		for (T t : entity) {
			save(t);
		}
	}

	public void saveOrUpdate(T entity) throws DataAccessException {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	public void delete(T entity) throws DataAccessException {
		getHibernateTemplate().delete(entity);
	}

	public void delete(List<T> entity) throws DataAccessException {
		for (T t : entity) {
			delete(t);
		}
	}

	public void update(T entity) throws DataAccessException {
		getHibernateTemplate().update(entity);
	}

	public void update(List<T> entity) throws DataAccessException {
		for (T t : entity) {
			update(t);
		}
	}

	public T get(String id) throws DataAccessException {
		return (T) getHibernateTemplate().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String dml, Object... params) {
		return (List<T>) getHibernateTemplate().find(dml, params);
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String dml, Map<String, Object> map) throws TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException, DataAccessException {
		List<T> result = null;
		config.setTemplateLoader(templateLoader);
		Template t = config.getTemplate(dml);
		StringWriter sw = new StringWriter();
		t.process(map, sw);
		if (t.getName().contains("sql")) {
			SQLQuery query = getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sw.toString())
					.addEntity(clazz);
			result = query.list();
		} else {
			result = (List<T>) getHibernateTemplate().find(sw.toString());
		}
		return result;
	}

	public List<T> find(String dml, List<Filter> filter) throws DataAccessException, TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		List<T> result = null;
		Map<String, Object> map = new HashMap<String, Object>();
		if (filter != null && filter.size() > 0) {
			map.put("filter", filter);
		}
		result = find(dml, map);
		return result;
	}

	public int executeUpdate(String dml, Map<String, Object> map) throws TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		int result = 0;
		config.setTemplateLoader(templateLoader);
		Template t = config.getTemplate(dml);
		StringWriter sw = new StringWriter();
		t.process(map, sw);
		SQLQuery query = getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sw.toString());
		result = query.executeUpdate();
		return result;
	}

	public ProcedureOutputs execute(String proc, ProcParameter... params) throws DataAccessException {
		ProcedureOutputs result = null;
		if (proc != null && !proc.trim().equals("")) {
			result = (ProcedureOutputs) getHibernateTemplate().execute(new HibernateCallback<Object>() {
				public Object doInHibernate(Session session) throws HibernateException {
					ProcedureOutputs result = null;
					ProcedureCall procCall = session.createStoredProcedureCall(proc);
					if (params != null && params.length > 0) {
						for (ProcParameter p : params) {
							if (p.getClassName().equals("int")) {
								if (p.getPm().equals(ParameterMode.IN)) {
									procCall.registerParameter(p.getKey(), int.class, p.getPm())
											.bindValue((int) p.getValue());
								}
								if (p.getPm().equals(ParameterMode.OUT)) {
									procCall.registerParameter(p.getKey(), int.class, p.getPm());
								}
							}
							if (p.getClassName().equals("java.lang.Integer")) {
								if (p.getPm().equals(ParameterMode.IN)) {
									procCall.registerParameter(p.getKey(), Integer.class, p.getPm())
											.bindValue((Integer) p.getValue());
								}
								if (p.getPm().equals(ParameterMode.OUT)) {
									procCall.registerParameter(p.getKey(), Integer.class, p.getPm());
								}
							}
							if (p.getClassName().equals("java.lang.String")) {
								if (p.getPm().equals(ParameterMode.IN)) {
									procCall.registerParameter(p.getKey(), String.class, p.getPm())
											.bindValue((String) p.getValue());
								}
								if (p.getPm().equals(ParameterMode.OUT)) {
									procCall.registerParameter(p.getKey(), String.class, p.getPm());
								}
							}
							if (p.getClassName().equals("boolean")) {
								if (p.getPm().equals(ParameterMode.IN)) {
									procCall.registerParameter(p.getKey(), boolean.class, p.getPm())
											.bindValue((boolean) p.getValue());
								}
								if (p.getPm().equals(ParameterMode.OUT)) {
									procCall.registerParameter(p.getKey(), boolean.class, p.getPm());
								}
							}
							if (p.getClassName().equals("java.lang.Boolean")) {
								if (p.getPm().equals(ParameterMode.IN)) {
									procCall.registerParameter(p.getKey(), Boolean.class, p.getPm())
											.bindValue((Boolean) p.getValue());
								}
								if (p.getPm().equals(ParameterMode.OUT)) {
									procCall.registerParameter(p.getKey(), Boolean.class, p.getPm());
								}
							}
							if (p.getClassName().equals("long")) {
								if (p.getPm().equals(ParameterMode.IN)) {
									procCall.registerParameter(p.getKey(), long.class, p.getPm())
											.bindValue((long) p.getValue());
								}
								if (p.getPm().equals(ParameterMode.OUT)) {
									procCall.registerParameter(p.getKey(), long.class, p.getPm());
								}
							}
							if (p.getClassName().equals("java.lang.Long")) {
								if (p.getPm().equals(ParameterMode.IN)) {
									procCall.registerParameter(p.getKey(), Long.class, p.getPm())
											.bindValue((Long) p.getValue());
								}
								if (p.getPm().equals(ParameterMode.OUT)) {
									procCall.registerParameter(p.getKey(), Long.class, p.getPm());
								}
							}
							if (p.getClassName().equals("float")) {
								if (p.getPm().equals(ParameterMode.IN)) {
									procCall.registerParameter(p.getKey(), float.class, p.getPm())
											.bindValue((float) p.getValue());
								}
								if (p.getPm().equals(ParameterMode.OUT)) {
									procCall.registerParameter(p.getKey(), float.class, p.getPm());
								}
							}
							if (p.getClassName().equals("java.lang.Float")) {
								if (p.getPm().equals(ParameterMode.IN)) {
									procCall.registerParameter(p.getKey(), Float.class, p.getPm())
											.bindValue((Float) p.getValue());
								}
								if (p.getPm().equals(ParameterMode.OUT)) {
									procCall.registerParameter(p.getKey(), Float.class, p.getPm());
								}
							}
							if (p.getClassName().equals("java.util.Date")) {
								if (p.getPm().equals(ParameterMode.IN)) {
									procCall.registerParameter(p.getKey(), Date.class, p.getPm())
											.bindValue((Date) p.getValue());
								}
								if (p.getPm().equals(ParameterMode.OUT)) {
									procCall.registerParameter(p.getKey(), Date.class, p.getPm());
								}
							}
						}
					}
					result = procCall.getOutputs();

					return result;
				}
			});
		}
		return result;
	}
}
