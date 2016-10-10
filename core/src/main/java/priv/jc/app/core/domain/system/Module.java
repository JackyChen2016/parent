package priv.jc.app.core.domain.system;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import priv.jc.app.core.domain.Domain;

/**
 * @author Jacky 模块
 */
@Entity
@Table(name = "ts_module")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Module extends Domain {
	private static final long serialVersionUID = -9556851790982953L;

	@Column(name = "name", nullable = false, unique = true, columnDefinition = "nvarchar2(20)")
	private String name;

	@Column(name = "leaf")
	private boolean leaf;

	@Column(name = "className", columnDefinition = "nvarchar2(40)")
	private String className;

	@Column(name = "icon", columnDefinition = "nvarchar2(20)")
	private String iconCls;

	@Column(name = "sort")
	private Integer sort;

	@Column(name = "parentId", columnDefinition = "nvarchar2(32)")
	private String parentId;

	@OneToMany(fetch = FetchType.EAGER, targetEntity = Module.class, cascade = { CascadeType.MERGE })
	@JoinColumns(value = { @JoinColumn(name = "parentid", referencedColumnName = "id") })
	private Set<Module> children;
	
	/*@OneToMany(fetch = FetchType.EAGER, targetEntity = Module.class, cascade = { CascadeType.ALL })
	@JoinColumns(value = { @JoinColumn(name = "id", referencedColumnName = "id") })
	private Set<Function> funList;*/

	public String getName() {
		return nullToEmpty(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public String getClassName() {
		return nullToEmpty(className);
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getIconCls() {
		return nullToEmpty(iconCls);
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getParentId() {
		return nullToEmpty(parentId);
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Set<Module> getChildren() {
		return children;
	}

	public void setChildren(Set<Module> children) {
		this.children = children;
	}

	/*public Set<Function> getFunList() {
		return funList;
	}

	public void setFunList(Set<Function> funList) {
		this.funList = funList;
	}*/
}
