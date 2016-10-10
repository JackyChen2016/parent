/**
 * 
 */
package priv.jc.util.web;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jacky_chen
 *
 */
public class ClientInfo {
	private HttpServletRequest request;

	private String ip;

	public String getIp() {
		return ip;
	}

	private String agent;

	public String getAgent() {
		return agent;
	}

	public ClientInfo(HttpServletRequest request) {
		this.request = request;
		getIpAddr();
		get_Agent();
	}

	/**
	 * 通过HttpServletRequest返回IP地址
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return ip String
	 * @throws Exception
	 */
	private void getIpAddr() {
		if (request != null) {
			ip = request.getHeader("x-forwarded-for");
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_CLIENT_IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
		}
	}
	
	private void get_Agent() {
		if (request != null) {
			agent = request.getHeader("User-Agent");
		}
	}
}
