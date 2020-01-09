package tw.com.iisi.fgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class FgsAPIEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FgsAPIEurekaServerApplication.class, args);
	}

}
