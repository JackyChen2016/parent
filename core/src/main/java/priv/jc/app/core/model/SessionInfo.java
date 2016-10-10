package priv.jc.app.core.model;

import java.util.Set;

import priv.jc.app.core.model.system.V_Module;
import priv.jc.app.core.model.system.V_User;

public class SessionInfo {
	private String loginTime;

	private V_User user;

	private Set<V_Module> root;

	public V_User getUser() {
		return user;
	}

	public void setUser(V_User user) {
		this.user = user;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public Set<V_Module> getRoot() {
		return root;
	}

	public void setRoot(Set<V_Module> root) {
		this.root = root;
	}
}
