/**
 * 
 */
package priv.jc.app.core.dao.system.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import priv.jc.app.core.dao.impl.DaoImpl;
import priv.jc.app.core.dao.impl.Filter;
import priv.jc.app.core.dao.system.FunctionDao;
import priv.jc.app.core.domain.system.Function;
import priv.jc.app.core.domain.system.M2M;

/**
 * @author Jacky
 *
 */
public class FunctionDaoImpl extends DaoImpl<Function>implements FunctionDao {
	public FunctionDaoImpl() {
		setClazz(Function.class);
	}

	public List<Function> find(List<Filter> filter) throws DataAccessException, TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		return find(FunctionEnum.function_find.toString(), filter);
	}

	@Override
	public List<Function> inFun(M2M t_User_Module) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		List<Function> result = null;
		Map<String, Object> map = null;
		if (t_User_Module != null) {
			map = new HashMap<String, Object>();
			map.put("tm_id", t_User_Module.getTm_id());
			map.put("ts_id", t_User_Module.getTs_id());
			result = find(FunctionEnum.sql_in_fun.toString(), map);
		}
		return result;
	}

	@Override
	public List<Function> unFun(M2M t_User_Module) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		List<Function> result = null;
		Map<String, Object> map = null;
		if (t_User_Module != null) {
			map = new HashMap<String, Object>();
			map.put("tm_id", t_User_Module.getTm_id());
			map.put("ts_id", t_User_Module.getTs_id());
			result = find(FunctionEnum.sql_un_fun.toString(), map);
		}
		return result;
	}
}
