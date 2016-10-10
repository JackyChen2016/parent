/**
 * 
 */
package priv.jc.app.core.interceptor;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import priv.jc.app.core.domain.system.SessionLog;
import priv.jc.app.core.model.SessionInfo;
import priv.jc.app.core.service.Service;
import priv.jc.util.date.DateTime;
import priv.jc.util.web.ClientInfo;

/**
 * @author jacky_chen 会话日志
 */
public class SessionLogInterceptor extends HandlerInterceptorAdapter {
	protected Service<SessionLog> service;

	public void setService(Service<SessionLog> service) {
		this.service = service;
	}

	private NamedThreadLocal<SessionLog> tl_sessionLog = new NamedThreadLocal<SessionLog>("sys_log");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean result = false;
		SessionLog sessionLog = getSessionLog(request);
		if (sessionLog != null) {
			service.save(sessionLog);
			tl_sessionLog.set(sessionLog);
		}
		result = true;
		return result;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		SessionLog sessionLog = tl_sessionLog.get();
		upSessionLog(request, response, sessionLog, ex);
		service.update(sessionLog);
	}

	private SessionLog getSessionLog(HttpServletRequest request) throws IOException {
		SessionLog result = null;
		if (request != null) {
			result = new SessionLog();
			ClientInfo clientInfo = new ClientInfo(request);
			result.setAgent(clientInfo.getAgent());
			result.setIp(clientInfo.getIp());
			result.setUri(request.getRequestURI());
			result.setUrl(request.getRequestURL().toString());

			HttpSession session = request.getSession(true);
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(request.getSession().getId());
			result.setCreateUser(clientInfo.getIp());
			if (sessionInfo != null && sessionInfo.getUser() != null) {
				result.setCreateUser(sessionInfo.getUser().getChName());
			}
		}
		return result;
	}

	private void upSessionLog(HttpServletRequest request, HttpServletResponse response, SessionLog sessionLog,
			Exception ex) throws IOException, ParseException {
		if (response != null && sessionLog != null) {
			HttpSession session = request.getSession(true);
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(request.getSession().getId());
			ClientInfo clientInfo = new ClientInfo(request);
			sessionLog.setUpdateUser(clientInfo.getIp());
			if (sessionInfo != null && sessionInfo.getUser() != null) {
				sessionLog.setUpdateUser(sessionInfo.getUser().getChName());
			}
			sessionLog.setUpdateTime(DateTime.ToString(new Date(), "yyyy/MM/dd HH:mm:ss"));
			if (ex != null)
				sessionLog.setError(ex.getMessage());
		}
	}
}
