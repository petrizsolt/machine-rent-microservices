package hu.machinerental.api_gateway_for_frontend.feignclients.customers;

import java.util.List;
import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import hu.machinerental.api_gateway_for_frontend.feignclients.customers.dto.CreateCustomerReq;
import hu.machinerental.api_gateway_for_frontend.feignclients.customers.dto.Customer;
import jakarta.validation.Valid;

@FeignClient(name = "CUSTOMER-MICROSERVICE", path = "/api/customers")
public interface CustomersClient {
	
	@GetMapping
	public List<Customer> findAll();
	
	@GetMapping("/find-by-id")
	public Customer findByid(@RequestParam UUID id);
	
	@PostMapping("/create")
	public Customer createMachine(@RequestBody @Valid CreateCustomerReq req);
	
	@PutMapping("/modify")
	public Customer modifyMachine(@RequestBody @Valid CreateCustomerReq req, 
			@RequestParam UUID id);

	@DeleteMapping("/delete-by-id")
	public void deleteById(@RequestParam UUID id);
}
