package hu.machinerental.rental_microservice.feignclients.customer;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import hu.machinerental.rental_microservice.feignclients.customer.dto.Customer;

@FeignClient("CUSTOMER-MICROSERVICE")
public interface CustomersClient {
	
	@GetMapping("/api/customers")
	List<Customer> findAll();
}
