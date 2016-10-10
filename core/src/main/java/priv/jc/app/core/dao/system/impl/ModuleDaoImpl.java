/**
 * 
 */
package priv.jc.app.core.dao.system.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import priv.jc.app.core.dao.impl.DaoImpl;
import priv.jc.app.core.dao.impl.Filter;
import priv.jc.app.core.dao.system.ModuleDao;
import priv.jc.app.core.domain.system.Module;

/**
 * @author Jacky
 *
 */
public class ModuleDaoImpl extends DaoImpl<Module>implements ModuleDao {
	public ModuleDaoImpl() {
		setClazz(Module.class);
	}

	public List<Module> getRoot() throws TemplateNotFoundException, DataAccessException, MalformedTemplateNameException,
			ParseException, IOException, TemplateException {
		List<Module> result = null;
		Map<String, Object> map = null;
		result = find(ModuleEnum.get_root.toString(), map);
		return result;
	}

	@Override
	public List<Module> find(List<Filter> filter) throws DataAccessException, TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		return find(ModuleEnum.module_find.toString(), filter);
	}
}
