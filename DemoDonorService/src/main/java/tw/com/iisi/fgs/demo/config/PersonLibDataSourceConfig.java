package tw.com.iisi.fgs.demo.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "personlibEntityManagerFactory",
        transactionManagerRef = "personlibTransactionManager",
        basePackages = { "tw.com.iisi.fgs.demo.personlib.repository" })
@Configuration
public class PersonLibDataSourceConfig {
	
    @ConfigurationProperties(prefix = "personlib.datasource")
    @Bean(name = "personlibDataSource")
    public DataSource personlibDataSource () {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "personlibEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean personlibEntityManagerFactory (
            EntityManagerFactoryBuilder builder,
            @Qualifier("personlibDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("tw.com.iisi.fgs.demo.personlib.entity")
                .persistenceUnit("integeratoer").build();
    }

    @Bean(name = "personlibTransactionManager")
    public PlatformTransactionManager personlibTransactionManager (
            @Qualifier("personlibEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
