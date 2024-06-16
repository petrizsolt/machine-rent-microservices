package hu.machinerental.rental_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class RentalMicroserviceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RentalMicroserviceApplication.class, args);
	}

}
