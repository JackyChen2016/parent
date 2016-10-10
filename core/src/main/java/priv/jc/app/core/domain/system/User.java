/**
 * 
 */
package priv.jc.app.core.domain.system;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import priv.jc.app.core.domain.Domain;
import priv.jc.app.core.domain.system.Function;
import priv.jc.app.core.domain.system.Role;
import priv.jc.util.excel.ExcelMeta;

/**
 * @author Jacky 用户信息
 */
@Entity
@Table(name = "tm_user")
public class User extends Domain {
	private static final long serialVersionUID = -8744610399809401652L;

	// 用户编码
	@Column(name = "no", nullable = false, unique = true, columnDefinition = "nvarchar2(8)")
	private String no;

	// 用户名
	@Column(name = "userName", length = 32, nullable = false, unique = true, columnDefinition = "nvarchar2(20)")
	@ExcelMeta(index = 0)
	private String userName;

	// 密码
	@Column(name = "password", length = 40, nullable = false, columnDefinition = "nvarchar2(40)")
	@ExcelMeta(index = 1)
	private String password;

	// 中文名
	@Column(name = "chName", length = 32, columnDefinition = "nvarchar2(20)")
	@ExcelMeta(index = 2)
	private String chName;

	// 英文名
	@Column(name = "enName", length = 32, columnDefinition = "nvarchar2(20)")
	@ExcelMeta(index = 3)
	private String enName;

	// 年龄
	@ExcelMeta(index = 4)
	private Integer age;

	// 性别 1 男性 0 女性
	@ExcelMeta(index = 5)
	private Boolean sex = true;

	// 手机号
	@Column(name = "telphone", unique = true, columnDefinition = "nvarchar2(15)")
	@ExcelMeta(index = 6)
	private String telphone;

	// 邮箱
	@Column(name = "email", unique = true, columnDefinition = "nvarchar2(50)")
	@ExcelMeta(index = 7)
	private String email;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "t_user_fun", joinColumns = @JoinColumn(name = "tm_user_id") , inverseJoinColumns = @JoinColumn(name = "ts_fun_id") )
	private Set<Function> funList;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "t_user_role", joinColumns = @JoinColumn(name = "tm_user_id") , inverseJoinColumns = @JoinColumn(name = "ts_role_id") )
	private Set<Role> roleList;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
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

	public Set<Function> getFunList() {
		return funList;
	}

	public void setFunList(Set<Function> funList) {
		this.funList = funList;
	}

	public Set<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}
}
