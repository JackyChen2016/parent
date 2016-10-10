package pers.jc.app.service.system;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.dao.DataAccessException;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import priv.jc.app.core.dao.system.impl.SessionLogDaoImpl;
import priv.jc.app.core.domain.system.SessionLog;
import priv.jc.app.core.service.impl.ServiceImpl;

public class SessionLogService extends ServiceImpl<SessionLog> {
	public SessionLogDaoImpl getDao() {
		return (SessionLogDaoImpl) super.getDao();
	}
	
	@Override
	public void save(List<SessionLog> entity) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException, java.text.ParseException {
		if (entity != null && entity.size() > 0) {
			Predicate<SessionLog> p = (v) -> v.getAdd();
			List<SessionLog> add = super.predicate(entity, p);
			p = (v) -> !v.getAdd();
			List<SessionLog> upd = super.predicate(entity, p);
			if (add != null && add.size() > 0) {
				super.save(add);
			}
			if (upd != null && upd.size() > 0) {
				super.update(upd);
			}
		}
	}
}
