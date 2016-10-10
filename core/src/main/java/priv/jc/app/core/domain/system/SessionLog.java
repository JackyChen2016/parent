/**
 * 
 */
package priv.jc.app.core.domain.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import priv.jc.app.core.domain.Domain;

/**
 * @author jacky_chen
 *
 */
@Entity
@Table(name = "ts_sessionLog")
public class SessionLog extends Domain {
	private static final long serialVersionUID = 8769890760581554024L;
	
	@Column(name = "ip", columnDefinition = "nvarchar2(20)")
	private String ip;
	
	@Column(name = "uri", columnDefinition = "nvarchar2(40)")
	private String uri;
	
	@Column(name = "url", columnDefinition = "nvarchar2(200)")
	private String url;
	
	@Column(name = "agent", columnDefinition = "nvarchar2(200)")
	private String agent;
	
	@Column(name = "error", columnDefinition = "nvarchar2(2000)")
	private String error;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
