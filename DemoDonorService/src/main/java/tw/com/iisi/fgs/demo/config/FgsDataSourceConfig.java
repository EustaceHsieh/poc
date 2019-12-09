package tw.com.iisi.fgs.demo.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "fgsdonationEntityManagerFactory",
        transactionManagerRef = "fgsdonationTransactionManager",
        basePackages = { "tw.com.iisi.fgs.demo.fgsdonation.repository" })
@Configuration
public class FgsDataSourceConfig {
	
    @Primary
    @ConfigurationProperties(prefix = "fgsdonation.datasource")
    @Bean(name = "fgsdonationDataSource")
    public DataSource fgsdonationDataSource () {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "fgsdonationEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean fgsdonationEntityManagerFactory (
            EntityManagerFactoryBuilder builder,
            @Qualifier("fgsdonationDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("tw.com.iisi.fgs.demo.fgsdonation.entity")
                .persistenceUnit("integeratoer").build();
    }

    @Primary
    @Bean(name = "fgsdonationTransactionManager")
    public PlatformTransactionManager fgsdonationTransactionManager (
            @Qualifier("fgsdonationEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
