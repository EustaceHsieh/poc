package tw.com.iisi.fgs.system.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class FgsDataSourceConfig {
	
    @Primary
    @ConfigurationProperties(prefix = "fgsdonation.datasource")
    @Bean(name = "fgsdonationDataSource")
    public DataSource fgsdonationDataSource () {
        return DataSourceBuilder.create().build();
    }
}
