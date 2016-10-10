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
import priv.jc.app.core.dao.system.RoleDao;
import priv.jc.app.core.domain.system.Role;

public class RoleDaoImpl extends DaoImpl<Role>implements RoleDao {
	public RoleDaoImpl() {
		setClazz(Role.class);
	}

	@Override
	public List<Role> find(List<Filter> filter) throws DataAccessException, TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		return find(RoleEnum.role_find.toString(), filter);
	}

	@Override
	public List<Role> inRole(String tm_user_id) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		List<Role> result = null;
		Map<String, Object> map = null;
		if (!tm_user_id.isEmpty()) {
			map = new HashMap<String, Object>();
			map.put("tm_user_id", tm_user_id);
			result = find(RoleEnum.sql_in_role.toString(), map);
		}
		return result;
	}

	@Override
	public List<Role> unRole(String tm_user_id) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		List<Role> result = null;
		Map<String, Object> map = null;
		if (!tm_user_id.isEmpty()) {
			map = new HashMap<String, Object>();
			map.put("tm_user_id", tm_user_id);
			result = find(RoleEnum.sql_un_role.toString(), map);
		}
		return result;
	}
}
