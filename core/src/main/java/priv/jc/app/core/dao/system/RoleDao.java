package priv.jc.app.core.dao.system;

import java.io.IOException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import priv.jc.app.core.domain.system.Role;

public interface RoleDao {
	public enum RoleEnum {
		role_find, sql_in_role, sql_un_role
	}

	List<Role> inRole(String tm_user_id) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException;

	List<Role> unRole(String tm_user_id) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException;
}
