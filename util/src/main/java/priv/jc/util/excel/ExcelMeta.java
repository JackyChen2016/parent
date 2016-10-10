/**
 * 
 */
package priv.jc.util.excel;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Jacky 
 * Excel注解类
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelMeta {
	/*
	 * 类字段所对应Excel文档中列的索引
	 */
	int index();
}
