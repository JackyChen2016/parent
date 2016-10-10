/**
 * 
 */
package priv.jc.app.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import priv.jc.app.core.model.SessionInfo;

/**
 * @author Jacky 登录拦截器
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean result = false;
		HttpSession session = request.getSession(true);
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(request.getSession().getId());
		if (sessionInfo != null && sessionInfo.getUser() != null) {
			result = true;
		}
		else
		{
			response.sendRedirect("/web/login");
			//response.getWriter().write(JsonResponseUtil.getResult(false, MessageInfo.err_msg + "会话过期失效或非法的会话！"));
		}
		return result;
	}

	/*
	 * 判断会话是否超时,true超时,false未超时
	 */
	/*private boolean isTimeout(Date lastSessionTime) {
		boolean result = false;
		result = (new Date().getTime() - lastSessionTime.getTime()) / (1000 * 60) > SystemParam.session_timeout;
		return result;
	}*/
}
