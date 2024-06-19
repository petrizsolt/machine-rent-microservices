package hu.machinerental.api_gateway_for_frontend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.machinerental.api_gateway_for_frontend.feignclients.customers.CustomersClient;
import hu.machinerental.api_gateway_for_frontend.feignclients.customers.dto.CreateCustomerReq;
import hu.machinerental.api_gateway_for_frontend.feignclients.customers.dto.Customer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/customers")
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class CustomersController {
	
	private final CustomersClient customersClient;
	
	@GetMapping
	public List<Customer> findAll() {
		return customersClient.findAll();
	}
	
	@GetMapping("/find-by-id")
	public Customer findByid(@RequestParam UUID id) {
		return customersClient.findByid(id);
	}
	
	@PostMapping("/create")
	public Customer createMachine(@RequestBody @Valid CreateCustomerReq req) {
		return customersClient.createMachine(req);
	}
	
	@PutMapping("/modify")
	public Customer modifyMachine(@RequestBody @Valid CreateCustomerReq req, 
			@RequestParam UUID id) {
		return customersClient.modifyMachine(req, id);
	}

	@DeleteMapping("/delete-by-id")
	public void deleteById(@RequestParam UUID id) {
		customersClient.deleteById(id);
	}
}
