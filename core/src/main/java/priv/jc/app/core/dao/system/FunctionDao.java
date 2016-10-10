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
import priv.jc.app.core.domain.system.Function;
import priv.jc.app.core.domain.system.M2M;

/**
 * @author Jacky
 *
 */
public interface FunctionDao {
	public enum FunctionEnum {
		function_find, sql_in_fun, sql_un_fun
	}

	List<Function> inFun(M2M t_User_Module) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException;

	List<Function> unFun(M2M t_User_Module) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException;
}
