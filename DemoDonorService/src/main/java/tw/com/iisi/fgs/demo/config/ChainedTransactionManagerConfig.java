package tw.com.iisi.fgs.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ChainedTransactionManagerConfig {
	
	@Bean(name = "chainedTransactionManager")
	public ChainedTransactionManager transactionManager (
			@Qualifier("fgsdonationTransactionManager") PlatformTransactionManager fgsdonationTransactionManager,
			@Qualifier("personlibTransactionManager") PlatformTransactionManager personlibTransactionManager) {
	    return new ChainedTransactionManager(fgsdonationTransactionManager, personlibTransactionManager);
	}
}
