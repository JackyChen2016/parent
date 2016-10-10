package priv.jc.app.core.dao.impl;

import java.io.Serializable;

/**
 * @author Jacky
 *
 */
public class Filter implements Serializable {
	private static final long serialVersionUID = 5157246329159208879L;

	private String logic;

	private String field;

	private String type;

	private String relation;

	private Object value;

	public String getLogic() {
		return logic;
	}

	public void setLogic(String logic) {
		this.logic = logic;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public Object getValue() {
		if (this.relation != null) {
			if (this.relation.toLowerCase().equals("like")) {
				this.value = "'%" + this.value + "%'";
			} else if (this.relation.toLowerCase().equals("in")) {
				this.value = "('" + this.value.toString().replace(",", "','") + "')";
			} else {
				this.value = "'" + this.value + "'";
			}
		}
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
