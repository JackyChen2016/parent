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
import priv.jc.app.core.domain.system.Module;

/**
 * @author Jacky
 *
 */
public interface ModuleDao {
	public enum ModuleEnum {
		get_root, module_find
	}

	List<Module> getRoot() throws TemplateNotFoundException, DataAccessException, MalformedTemplateNameException,
			ParseException, IOException, TemplateException;
}
