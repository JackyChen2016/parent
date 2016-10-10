/**
 * 
 */
package priv.jc.app.core.dao.system.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import priv.jc.app.core.dao.impl.DaoImpl;
import priv.jc.app.core.dao.impl.Filter;
import priv.jc.app.core.dao.system.SessionLogDao;
import priv.jc.app.core.domain.system.SessionLog;

/**
 * @author Jacky
 *
 */
public class SessionLogDaoImpl extends DaoImpl<SessionLog>implements SessionLogDao {
	public SessionLogDaoImpl() {
		setClazz(SessionLog.class);
	}

	@Override
	public List<SessionLog> find(List<Filter> filter) throws DataAccessException, TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		return find(SessionLogEnum.sessionLog_find.toString(), filter);
	}
}
