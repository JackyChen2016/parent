package priv.jc.app.core.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import priv.jc.app.core.dao.Dao;
import priv.jc.app.core.dao.DaoFactory;
import priv.jc.app.core.dao.DaoFactory.DaoFactoryEnum;
import priv.jc.app.core.dao.impl.DaoImpl;
import priv.jc.app.core.dao.impl.Filter;
import priv.jc.app.core.dao.system.SerialNumberDao;
import priv.jc.app.core.domain.Domain;
import priv.jc.app.core.domain.system.SerialNumber;
import priv.jc.app.core.service.Service;
import priv.jc.util.date.DateTime;

/**
 * @author Jacky
 *
 */
public abstract class ServiceImpl<T extends Domain> implements Service<T> {
	private final Log logger = LogFactory.getLog(getClass());

	private Dao<T> dao;

	private DaoFactory daoFactory;

	public Log getLogger() {
		return logger;
	}

	public void setDao(Dao<T> dao) {
		this.dao = dao;
	}

	public Dao<T> getDao() {
		return dao;
	}

	public Dao<?> getDao(String dao) {
		Dao<?> result = null;
		if (daoFactory != null) {
			result = daoFactory.createDao(dao);
		}
		return result;
	}

	public DaoFactory getDaoFactory() {
		return daoFactory;
	}

	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void save(T entity) {
		getDao().save(entity);
	}

	@Override
	public void save(List<T> entity) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException, java.text.ParseException {
		if (entity != null && entity.size() > 0) {
			Predicate<T> p = (v) -> v.getAdd();
			List<T> add = predicate(entity, p);
			p = (v) -> !v.getAdd();
			List<T> upd = predicate(entity, p);
			if (add != null && add.size() > 0) {
				getDao().save(add);
			}
			if (upd != null && upd.size() > 0) {
				getDao().update(entity);
			}
		}
	}

	@Override
	public void delete(T entity) {

	}

	@Override
	public void delete(List<T> entity) {

	}

	@Override
	public void update(T entity) {
		getDao().update(entity);
	}

	@Override
	public void update(List<T> entity) {
		getDao().update(entity);
	}

	@Override
	public List<T> find(List<Filter> filter) throws DataAccessException, TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		return getDao().find(filter);
	}

	@Override
	public T get(String id) {
		return null;
	}

	public List<T> predicate(List<T> list, Predicate<T> p) {
		List<T> result = new ArrayList<T>();
		for (T o : list) {
			if (p.test(o)) {
				result.add(o);
			}
		}
		return result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String getSerialNumber(int serialType) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException, java.text.ParseException {
		String result = null;
		List<SerialNumber> list = ((SerialNumberDao) getDao(DaoFactoryEnum.serialNumber.toString()))
				.getSerialNumber(serialType);
		if (list != null && list.size() == 1) {
			SerialNumber sn = list.get(0);
			String serialDate = sn.getSerialDate();
			Integer serialValue = sn.getSerialValue() + 1;
			if (!serialDate.isEmpty()
					&& DateTime.DayDifference(DateTime.ToDate(serialDate, "yyyy/MM/dd HH:mm:ss")) != 0) {
				serialDate = DateTime.ToDate(new Date(), "yyyy/MM/dd HH:mm:ss");
				serialValue = 1;
			}
			sn.setSerialDate(serialDate);
			sn.setSerialValue(serialValue);
			((DaoImpl) getDao(DaoFactoryEnum.serialNumber.toString())).update(sn);
			result = sn.getPrefix() + serialDate + String.format("%0" + sn.getLength() + "d", serialValue)
					+ sn.getSuffix();
		}
		return result;
	}
}
