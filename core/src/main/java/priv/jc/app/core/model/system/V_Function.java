package priv.jc.app.core.model.system;

import priv.jc.app.core.domain.system.Function;
import priv.jc.app.core.model.Model;

public class V_Function extends Model implements Comparable<Object> {

	private static final long serialVersionUID = -781544982780769831L;
	
	private String name;
	private String scale;
	private String icon;
	private int sort;
	private String click;
	private String url;
	private Boolean enableToggle;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
	
	public String getClick() {
		return click;
	}

	public void setClick(String click) {
		this.click = click;
	}

	public String getUrl() {
		return url;
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

	public static V_Function parse(Function domain) {
		V_Function result = null;
		if (domain != null) {
			result = new V_Function();
			result.parseDomain(domain);
			result.setName(domain.getName());
			result.setScale(domain.getScale());
			result.setIcon(domain.getFunIcon());
			result.setSort(domain.getSort());
			result.setClick(domain.getClick());
			result.setUrl(domain.getUrl());
			result.setEnableToggle(domain.getEnableToggle());
		}
		return result;
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		V_Function f = (V_Function)o;
		return this.sort - f.getSort();
	}
}
