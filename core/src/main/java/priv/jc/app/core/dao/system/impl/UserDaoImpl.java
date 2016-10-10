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
import priv.jc.app.core.dao.system.UserDao;
import priv.jc.app.core.domain.system.User;

/**
 * @author Jacky
 *
 */
public class UserDaoImpl extends DaoImpl<User>implements UserDao {
	public UserDaoImpl() {
		setClazz(User.class);
	}

	public List<User> find(List<Filter> filter) throws DataAccessException, TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		return find(UserEnum.user_find.toString(), filter);
	}

	public List<User> find(String key) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		List<User> result = null;
		Map<String, Object> map = null;
		if (!key.isEmpty()) {
			map = new HashMap<String, Object>();
			map.put("userName", key);
			map.put("telphone", key);
			map.put("email", key);
			result = find(UserEnum.user_login.toString(), map);
		}
		return result;
	}

	@Override
	public List<User> inUser(String ts_role_id) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		List<User> result = null;
		Map<String, Object> map = null;
		if (!ts_role_id.isEmpty()) {
			map = new HashMap<String, Object>();
			map.put("ts_role_id", ts_role_id);
			result = find(UserEnum.sql_in_user.toString(), map);
		}
		return result;
	}

	@Override
	public List<User> unUser(String ts_role_id) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		List<User> result = null;
		Map<String, Object> map = null;
		if (!ts_role_id.isEmpty()) {
			map = new HashMap<String, Object>();
			map.put("ts_role_id", ts_role_id);
			result = find(UserEnum.sql_un_user.toString(), map);
		}
		return result;
	}
}
