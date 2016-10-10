package pers.jc.app.service.system;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.dao.DataAccessException;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import priv.jc.app.core.dao.system.impl.FunctionDaoImpl;
import priv.jc.app.core.domain.system.Function;
import priv.jc.app.core.domain.system.M2M;
import priv.jc.app.core.service.impl.ServiceImpl;

/**
 * @author Jacky
 *
 */
public class FunctionService extends ServiceImpl<Function> {
	public FunctionDaoImpl getDao() {
		return (FunctionDaoImpl) super.getDao();
	}
	
	@Override
	public void save(List<Function> entity) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException, java.text.ParseException {
		if (entity != null && entity.size() > 0) {
			Predicate<Function> p = (v) -> v.getAdd();
			List<Function> add = super.predicate(entity, p);
			p = (v) -> !v.getAdd();
			List<Function> upd = super.predicate(entity, p);
			if (add != null && add.size() > 0) {
				super.save(add);
			}
			if (upd != null && upd.size() > 0) {
				super.update(upd);
			}
		}
	}
	
	public List<Function> inFun(M2M t_User_Module) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		List<Function> result = null;
		result = getDao().inFun(t_User_Module);
		return result;
	}

	public List<Function> unFun(M2M t_User_Module) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		List<Function> result = null;
		result = getDao().unFun(t_User_Module);
		return result;
	}
}
