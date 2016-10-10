/**
 * 
 */
package priv.jc.app.core.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Jacky 实体对象的基类
 */
@MappedSuperclass
public class Domain implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5357152366515446117L;

	@Transient
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	// 主键 唯一 不可为空 guid
	@Id
	@GenericGenerator(name = "id", strategy = "uuid")
	@GeneratedValue(generator = "id")
	@Column(name = "id", columnDefinition = "nvarchar2(32)")
	private String id;

	// 乐观锁
	private Timestamp version;

	// 标记数据的可用状态 1：启用 0：禁用
	@Column(name = "enabled", nullable = false)
	private Boolean enabled = true;

	// 用于数据的假删除，标记数据是否已删除 1：删除 0：未删除
	@Column(name = "del", nullable = false)
	private Boolean del = false;

	// 数据备注
	@Column(name = "remark", nullable = true, columnDefinition = "nvarchar2(2000)")
	private String remark;

	// 数据的创建人
	@Column(name = "createUser", nullable = false, columnDefinition = "nvarchar2(20)")
	private String createUser;

	// 数据的最后更新人
	@Column(name = "updateUser", nullable = true, columnDefinition = "nvarchar2(20)")
	private String updateUser;

	// 数据的创建时间
	@Column(name = "createTime", nullable = false, columnDefinition = "nvarchar2(19)")
	private String createTime = dateFormat.format(new Date());

	// 数据的最后更新时间
	@Column(name = "updateTime", nullable = true, columnDefinition = "nvarchar2(19)")
	private String updateTime;

	@Transient
	private Boolean add;

	// 数据操作日志
	// private List<OperatorInfo> operatorInfos;

	public Boolean getAdd() {
		return add;
	}

	public void setAdd(Boolean add) {
		this.add = add;
	}

	public String getId() {
		return nullToEmpty(id);
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getVersion() {
		return version;
	}

	public void setVersion(Timestamp version) {
		this.version = version;
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
		return nullToEmpty(remark);
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateUser() {
		return nullToEmpty(createUser);
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return nullToEmpty(updateUser);
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getCreateTime() {
		return nullToEmpty(createTime);
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
		/*
		 * if (createTime != null) this.createTime =
		 * dateFormat.format(createTime);
		 */
	}

	public String getUpdateTime() {
		return nullToEmpty(updateTime);
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
		/*
		 * if (updateTime != null) this.updateTime =
		 * dateFormat.format(updateTime);
		 */
	}

	public String nullToEmpty(String str) {
		return str == null ? "" : str;
	}

	/*
	 * public List<OperatorInfo> getOperatorInfos() { return operatorInfos; }
	 * 
	 * public void setOperatorInfos(List<OperatorInfo> operatorInfos) {
	 * this.operatorInfos = operatorInfos; }
	 */
}
