/**
 * 
 */
package priv.jc.app.core.domain.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import priv.jc.app.core.domain.Domain;
import priv.jc.util.excel.ExcelMeta;

/**
 * @author Jacky 系统编码流水
 */
@Entity
@Table(name = "ts_serialNumber")
public class SerialNumber extends Domain {
	private static final long serialVersionUID = -2059280643622787254L;

	@Column(name = "prefix", nullable = true, columnDefinition = "nvarchar2(5)")
	@ExcelMeta(index = 0)
	private String prefix;

	@Column(name = "suffix", nullable = true, columnDefinition = "nvarchar2(5)")
	@ExcelMeta(index = 1)
	private String suffix;

	@Column(name = "serialType", unique = true)
	@ExcelMeta(index = 2)
	private Integer serialType;

	@ExcelMeta(index = 3)
	private Integer length;

	@Column(nullable = true, columnDefinition = "nvarchar2(10)")
	@ExcelMeta(index = 4)
	private String serialDate;

	@ExcelMeta(index = 5)
	private Integer serialValue;

	public String getPrefix() {
		return nullToEmpty(prefix);
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return nullToEmpty(suffix);
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Integer getSerialType() {
		return serialType;
	}

	public void setSerialType(Integer serialType) {
		this.serialType = serialType;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getSerialDate() {
		return nullToEmpty(serialDate);
	}

	public void setSerialDate(String serialDate) {
		this.serialDate = serialDate;
	}

	public Integer getSerialValue() {
		return serialValue;
	}

	public void setSerialValue(Integer serialValue) {
		this.serialValue = serialValue;
	}
}
