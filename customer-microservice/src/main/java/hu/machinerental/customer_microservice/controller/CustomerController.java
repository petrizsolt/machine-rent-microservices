package hu.machinerental.customer_microservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.machinerental.customer_microservice.model.entity.Customer;
import hu.machinerental.customer_microservice.service.CustomerService;
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
//	
//	@PostMapping("/create")
//	public Machine createMachine(@RequestBody @Valid CreateMachineReq req) {
//		return machineService.createMachine(req);
//	}
//	
//	@PutMapping("/modify")
//	public Machine modifyMachine(@RequestBody @Valid CreateMachineReq req, @RequestParam UUID id) {
//		return machineService.modifyMachine(req, id);
//	}
//	
//	@DeleteMapping("/delete-by-id")
//	public void deleteById(@RequestParam UUID id) {
//		machineService.deleteById(id);
//	}
}
