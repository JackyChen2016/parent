package priv.jc.app.core.model.system;

import priv.jc.app.core.domain.system.User;
import priv.jc.app.core.model.Model;

public class V_User extends Model {

	private static final long serialVersionUID = -4305944730744038503L;
	
	private String userName;

	private String password;

	private String chName;

	private String enName;

	private Integer age;

	private Boolean sex = true;

	private String telphone;

	private String email;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getChName() {
		return chName;
	}

	public void setChName(String chName) {
		this.chName = chName;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static V_User parse(User domain) {
		V_User result = null;
		if (domain != null) {		
			result = new V_User();
			result.parseDomain(domain);
			result.setUserName(domain.getUserName());
			result.setChName(domain.getChName());
		}
		return result;
	}
}
