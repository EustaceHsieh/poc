package tw.com.iisi.fgs.system.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "fgsdonationEntityManagerFactory",
        transactionManagerRef = "fgsdonationTransactionManager",
        basePackages = { "tw.com.iisi.fgs.dao.fgsdonation" })
@EntityScan(basePackages ="tw.com.iisi.fgs.bo.fgsdonation")
public class FgsTransactionManagerConfig {
	
	@Autowired
    private DataSource fgsdonationDataSource;

    @Primary
    @Bean(name = "fgsdonationEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean fgsdonationEntityManagerFactory (
            EntityManagerFactoryBuilder builder,
            @Qualifier("fgsdonationDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("tw.com.iisi.fgs.bo.fgsdonation").build();
    }

    @Primary
    @Bean(name = "fgsdonationTransactionManager")
    public PlatformTransactionManager fgsdonationTransactionManager (
            @Qualifier("fgsdonationEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

	public DataSource getFgsdonationDataSource() {
		return fgsdonationDataSource;
	}

	public void setFgsdonationDataSource(DataSource fgsdonationDataSource) {
		this.fgsdonationDataSource = fgsdonationDataSource;
	}

}
