package pers.jc.app.service.system;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.dao.DataAccessException;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import priv.jc.app.core.dao.system.impl.RoleDaoImpl;
import priv.jc.app.core.domain.system.Role;
import priv.jc.app.core.service.impl.ServiceImpl;

/**
 * @author Jacky
 *
 */
public class RoleService extends ServiceImpl<Role> {
	public RoleDaoImpl getDao() {
		return (RoleDaoImpl) super.getDao();
	}

	@Override
	public void save(List<Role> entity) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException, java.text.ParseException {
		if (entity != null && entity.size() > 0) {
			Predicate<Role> p = (v) -> v.getAdd();
			List<Role> add = super.predicate(entity, p);
			p = (v) -> !v.getAdd();
			List<Role> upd = super.predicate(entity, p);
			if (add != null && add.size() > 0) {
				for (Role d : add) {
					d.setRoleNo(super.getSerialNumber(1));
				}
				super.save(add);
			}
			if (upd != null && upd.size() > 0) {
				super.update(upd);
			}
		}
	}

	public List<Role> inRole(String tm_user_id) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		List<Role> result = null;
		result = getDao().inRole(tm_user_id);
		return result;
	}

	public List<Role> unRole(String tm_user_id) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		List<Role> result = null;
		result = getDao().unRole(tm_user_id);
		return result;
	}
}
