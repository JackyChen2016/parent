/**
 * 
 */
package priv.jc.app.core.dao.impl;

import javax.persistence.ParameterMode;

/**
 * @author Jacky
 *
 */
public class ProcParameter {
	public ProcParameter(String className, ParameterMode pm, String key, Object value) {
		this.className = className;
		this.pm = pm;
		this.key = key;
		this.value = value;
	}

	private String className;

	private ParameterMode pm;

	private String key;

	private Object value;

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className
	 *            the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the pm
	 */
	public ParameterMode getPm() {
		return pm;
	}

	/**
	 * @param pm
	 *            the pm to set
	 */
	public void setPm(ParameterMode pm) {
		this.pm = pm;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}
}
