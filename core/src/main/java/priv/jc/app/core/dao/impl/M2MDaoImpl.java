package priv.jc.app.core.dao.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import priv.jc.app.core.dao.M2MDao;
import priv.jc.app.core.domain.Domain;
import priv.jc.app.core.domain.system.M2M;

public class M2MDaoImpl<T extends Domain> extends DaoImpl<T>implements M2MDao {

	@Override
	public List<T> find(List<Filter> filter) throws DataAccessException, TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		return null;
	}

	@Override
	public int add(String name, List<M2M> list) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException,
			IOException, TemplateException {
		int result = 0;
		Map<String, Object> map = null;
		if (list != null && list.size() > 0) {
			map = new HashMap<String, Object>();
			for (M2M t : list) {
				map.put("tm_id", t.getTm_id());
				map.put("ts_id", t.getTs_id());
				result += executeUpdate(name, map);
			}
		}
		return result;
	}

	@Override
	public int del(String name, List<M2M> list) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException,
			IOException, TemplateException {
		int result = 0;
		Map<String, Object> map = null;
		if (list != null && list.size() > 0) {
			map = new HashMap<String, Object>();
			for (M2M t : list) {
				map.put("tm_id", t.getTm_id());
				map.put("ts_id", t.getTs_id());
				result += executeUpdate(name, map);
			}
		}
		return result;
	}

}
