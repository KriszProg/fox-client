package hu.foxpost.fox_client;

import hu.foxpost.fox_client.properties.OpenApiProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties({ OpenApiProperties.class })
public class FoxClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoxClientApplication.class, args);
	}

}
