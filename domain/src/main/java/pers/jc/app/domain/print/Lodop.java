package pers.jc.app.domain.print;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import priv.jc.app.core.domain.Domain;

@Entity
@Table(name = "tr_lodop")
public class Lodop extends Domain  {
	private static final long serialVersionUID = 4667212522196196258L;
	
	//报表编码
	@Column(name = "no", nullable = false, unique = true, columnDefinition = "nvarchar2(4)")
	private String no;
	
	//报表名
	@Column(name = "name", length = 32, nullable = false, unique = true, columnDefinition = "nvarchar2(20)")
	private String name;
	
	//打印模板切换
	private Boolean def;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getDef() {
		return def;
	}

	public void setDef(Boolean def) {
		this.def = def;
	}
}
