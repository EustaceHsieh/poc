package tw.com.iisi.fgs.system.config;

import java.sql.Types;

import org.hibernate.dialect.SQLServer2012Dialect;
import org.hibernate.type.StandardBasicTypes;

public class FgsSQLServerDialect extends SQLServer2012Dialect {
	public FgsSQLServerDialect () {
        super();
        registerHibernateType(1, "string");     
        registerHibernateType(-9, "string");     
        registerHibernateType(-15, "string");     
        registerHibernateType(-16, "string");     
        registerHibernateType(3, "double");  
          
        registerHibernateType(Types.CHAR, StandardBasicTypes.STRING.getName());     
        registerHibernateType(Types.NVARCHAR, StandardBasicTypes.STRING.getName());
        registerHibernateType(Types.NCHAR, StandardBasicTypes.STRING.getName()); 
        registerHibernateType(Types.LONGNVARCHAR, StandardBasicTypes.STRING.getName());     
        registerHibernateType(Types.DECIMAL, StandardBasicTypes.DOUBLE.getName());
    }
}
