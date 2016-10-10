package priv.jc.app.core.dao.impl;

import java.sql.Types;

import org.hibernate.dialect.Oracle10gDialect;
import org.hibernate.type.StandardBasicTypes;

public class Oracle11gDialect extends Oracle10gDialect {
	public Oracle11gDialect() {
		super();
		registerHibernateType(Types.CHAR, StandardBasicTypes.STRING.getName());
		registerHibernateType(Types.NVARCHAR, StandardBasicTypes.STRING.getName());
		registerHibernateType(Types.LONGNVARCHAR, StandardBasicTypes.STRING.getName());
		registerHibernateType(Types.DECIMAL, StandardBasicTypes.DOUBLE.getName());
		registerHibernateType(Types.NCLOB, StandardBasicTypes.STRING.getName());
	}
}
