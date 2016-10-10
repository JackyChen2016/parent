package pers.jc.app.action.system;

import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.jc.app.core.action.impl.ControllerImpl;
import priv.jc.app.core.dao.impl.Filter;
import priv.jc.app.core.domain.system.SessionLog;

public class SessionLogController extends ControllerImpl<SessionLog> {
	public SessionLogController(){
		setClazz(SessionLog.class);
	}

	@RequestMapping(value = "find_SessionLog", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public Object find(@RequestBody Filter[] filter) {
		return super.find(service, Arrays.asList(filter));
	}
}
