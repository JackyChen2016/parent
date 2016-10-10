package priv.jc.app.core.model.system;

import java.util.HashSet;
import java.util.Set;

import priv.jc.app.core.domain.system.Module;
import priv.jc.app.core.model.Model;

public class V_Module extends Model {

	private static final long serialVersionUID = 1457966569591867900L;

	private String text;
	private boolean leaf;	
	private String className;	
	private String iconCls;	
	private int sort;
	private String parentid;
	private Set<V_Module> children;
	private Set<V_Function> funList;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public Set<V_Module> getChildren() {
		return children;
	}

	public void setChildren(Set<V_Module> children) {
		this.children = children;
	}

	public Set<V_Function> getFunList() {
		return funList;
	}

	public void setFunList(Set<V_Function> funList) {
		this.funList = funList;
	}

	public static V_Module parse(Module domain, boolean leaf) {
		V_Module result = null;
		if (domain != null && (leaf || !domain.isLeaf())) {
			result = new V_Module();
			result.parseDomain(domain);
			result.setText(domain.getName());
			result.setClassName(domain.getClassName());
			result.setIconCls(domain.getIconCls());
			result.setSort(domain.getSort());
			result.setParentid(domain.getParentId());
			result.setLeaf(domain.isLeaf());
			if (domain.getChildren() != null && domain.getChildren().size() > 0) {
				Set<V_Module> children = new HashSet<V_Module>();
				for (Module m : domain.getChildren()) {
					if (m != null && (leaf || !m.isLeaf()))
						children.add(V_Module.parse(m, leaf));
				}
				result.setChildren(children);
			}
		}
		return result;
	}

}
