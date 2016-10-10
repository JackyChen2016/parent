/**
 * 
 */
package priv.jc.app.core.dao;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.dao.DataAccessException;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import priv.jc.app.core.dao.impl.Filter;
import priv.jc.app.core.dao.impl.ProcParameter;
import priv.jc.app.core.domain.Domain;

/**
 * @author Jacky 数据访问层接口定义
 */
public interface Dao<T extends Domain> {
	Serializable save(T entity);

	void save(List<T> entity);

	void saveOrUpdate(T entity);

	void delete(T entity);

	void delete(List<T> entity);

	void update(T entity);

	void update(List<T> entity);

	T get(String id);

	List<T> find(String dml, Object... params);

	List<T> find(List<Filter> filter) throws DataAccessException, TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException;

	List<T> find(String dml, Map<String, Object> map) throws TemplateNotFoundException, MalformedTemplateNameException,
			ParseException, IOException, TemplateException;

	List<T> find(String dml, List<Filter> filter) throws DataAccessException, TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException;

	int executeUpdate(String dml, Map<String, Object> map) throws TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException;

	ProcedureOutputs execute(String proc, ProcParameter... params);
}
