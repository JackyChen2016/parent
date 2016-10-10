package priv.jc.app.core.service;

import java.io.IOException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import priv.jc.app.core.dao.Dao;
import priv.jc.app.core.dao.impl.Filter;
import priv.jc.app.core.domain.Domain;

/**
 * @author Jacky
 *
 */
public interface Service<T extends Domain> {
	Dao<?> getDao(String dao);

	void save(T entity);

	void save(List<T> entity) throws TemplateNotFoundException, DataAccessException, MalformedTemplateNameException,
			ParseException, IOException, TemplateException, java.text.ParseException;

	void delete(T entity);

	void delete(List<T> entity);

	void update(T entity);

	void update(List<T> entity);

	List<T> find(List<Filter> filter) throws DataAccessException, TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException;

	T get(String id);

	String getSerialNumber(int serialType) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException, java.text.ParseException;
}
