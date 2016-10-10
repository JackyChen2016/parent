package priv.jc.app.core.model;

import java.io.Serializable;

import priv.jc.app.core.domain.Domain;

public class Model implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7236885930444404621L;

	private String id;

	// 标记数据的可用状态 1：启用 0：禁用
	private Boolean enabled = true;

	// 用于数据的假删除，标记数据是否已删除 1：删除 0：未删除
	private Boolean del = false;

	// 数据备注
	private String remark;

	// 数据的创建人
	private String createUser;

	// 数据的最后更新人
	private String updateUser;

	// 数据的创建时间
	private String createTime;

	// 数据的最后更新时间
	private String updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getDel() {
		return del;
	}

	public void setDel(Boolean del) {
		this.del = del;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public void parseDomain(Domain domain){
		id = domain.getId();
		enabled = domain.getEnabled();
		del = domain.getDel();
		remark = domain.getRemark();
	    createUser = domain.getCreateUser();
		updateUser = domain.getCreateUser();
		createTime = domain.getCreateTime();
		updateTime = domain.getUpdateTime();
	}
}
