package tw.com.iisi.fgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FgsAPIServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FgsAPIServiceApplication.class, args);
	}
}