/**
 * 
 */
package priv.jc.app.core.dao.system;

import java.io.IOException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import priv.jc.app.core.domain.system.User;

/**
 * @author Jacky
 *
 */
public interface UserDao {
	public enum UserEnum {
		user_login, user_find, sql_in_user, sql_un_user
	}

	List<User> find(String key) throws TemplateNotFoundException, DataAccessException, MalformedTemplateNameException,
			ParseException, IOException, TemplateException;

	List<User> inUser(String ts_role_id) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException;

	List<User> unUser(String ts_role_id) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException;
}
