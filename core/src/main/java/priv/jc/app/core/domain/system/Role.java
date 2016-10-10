/**
 * 
 */
package priv.jc.app.core.domain.system;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import priv.jc.app.core.domain.Domain;

/**
 * @author Jacky 角色
 */
@Entity
@Table(name = "ts_role")
public class Role extends Domain {
	private static final long serialVersionUID = -7635976020613484484L;

	@Column(unique = true, nullable = false, columnDefinition = "nvarchar2(5)")
	private String roleNo;
	
	@Column(unique = true, nullable = false, columnDefinition = "nvarchar2(30)")
	private String roleName;

	@ManyToMany(mappedBy = "roleList", cascade = CascadeType.MERGE)
	private List<User> userList;

	public String getRoleNo() {
		return roleNo;
	}

	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@JsonIgnore
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
