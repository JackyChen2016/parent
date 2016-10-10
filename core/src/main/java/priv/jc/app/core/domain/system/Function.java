package priv.jc.app.core.domain.system;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import priv.jc.app.core.domain.Domain;

/**
 * @author Jacky 功能
 */
@Entity
@Table(name = "ts_fun", uniqueConstraints = { @UniqueConstraint(columnNames = { "ts_module_id", "sort" }) })
public class Function extends Domain {
	private static final long serialVersionUID = -9126446641821250070L;

	@Column(name = "name", nullable = false, columnDefinition = "nvarchar2(20)")
	private String name;

	@Column(name = "scale", columnDefinition = "nvarchar2(10)")
	private String scale;

	@Column(name = "icon", columnDefinition = "nvarchar2(20)")
	private String funIcon;

	@Column(name = "sort", nullable = false)
	private Integer sort;

	@Column(name = "click", columnDefinition = "nvarchar2(20)")
	private String click;

	@Column(name = "url", columnDefinition = "nvarchar2(40)")
	private String url;
	
	@Column(name = "enableToggle", nullable = false)
	private Boolean enableToggle;

	@ManyToOne(cascade = CascadeType.MERGE, optional = false)
	@JoinColumn(name = "ts_module_id", nullable = false, referencedColumnName = "id")
	private Module module;

	@ManyToMany(mappedBy = "funList", cascade = CascadeType.MERGE)
	private Set<User> userList;

	public String getName() {
		return nullToEmpty(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScale() {
		return nullToEmpty(scale);
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getFunIcon() {
		return nullToEmpty(funIcon);
	}

	public void setFunIcon(String funIcon) {
		this.funIcon = funIcon;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getClick() {
		return nullToEmpty(click);
	}

	public void setClick(String click) {
		this.click = click;
	}

	public String getUrl() {
		return nullToEmpty(url);
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getEnableToggle() {
		return enableToggle;
	}

	public void setEnableToggle(Boolean enableToggle) {
		this.enableToggle = enableToggle;
	}

	@JsonIgnore
	public Set<User> getUserList() {
		return userList;
	}

	public void setUserList(Set<User> userList) {
		this.userList = userList;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
}
