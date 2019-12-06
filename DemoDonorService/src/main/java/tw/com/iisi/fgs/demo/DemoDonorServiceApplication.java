package tw.com.iisi.fgs.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoDonorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoDonorServiceApplication.class, args);
	}
}