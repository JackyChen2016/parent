package pers.jc.app.service.system;

import java.io.IOException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import priv.jc.app.core.dao.system.impl.ModuleDaoImpl;
import priv.jc.app.core.domain.system.Module;
import priv.jc.app.core.service.impl.ServiceImpl;

/**
 * @author Jacky
 *
 */
public class ModuleService extends ServiceImpl<Module> {
	public ModuleDaoImpl getDao() {
		return (ModuleDaoImpl) super.getDao();
	}

	public List<Module> getRoot() throws TemplateNotFoundException, DataAccessException, MalformedTemplateNameException,
			ParseException, IOException, TemplateException {
		List<Module> result = null;
		result = getDao().getRoot();
		return result;
	}
}
