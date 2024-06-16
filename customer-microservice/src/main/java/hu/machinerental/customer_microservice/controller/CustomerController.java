package hu.machinerental.customer_microservice.controller;

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

import hu.machinerental.customer_microservice.model.dto.CreateCustomerReq;
import hu.machinerental.customer_microservice.model.entity.Customer;
import hu.machinerental.customer_microservice.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/customers")
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class CustomerController {
	
	private final CustomerService customerService;
	
	@GetMapping
	public List<Customer> findAll() {
		return customerService.findAll();
	}
	
	@GetMapping("/find-by-id")
	public Customer findByIdeintifier(@RequestParam UUID id) {
		return customerService.findByIdentifier(id);
	}
	
	@PostMapping("/create")
	public Customer createMachine(@RequestBody @Valid CreateCustomerReq req) {
		return customerService.createMachine(req);
	}
	
	@PutMapping("/modify")
	public Customer modifyMachine(@RequestBody @Valid CreateCustomerReq req, 
			@RequestParam UUID id) {
		return customerService.modifyMachine(req, id);
	}

	@DeleteMapping("/delete-by-id")
	public void deleteById(@RequestParam UUID id) {
		customerService.deleteById(id);
	}
}
