package hu.machinerental.customer_microservice.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.stereotype.Service;

import hu.machinerental.customer_microservice.model.dto.CreateCustomerReq;
import hu.machinerental.customer_microservice.model.entity.Customer;
import hu.machinerental.customer_microservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {
	
	private final CustomerRepository customerRepo;
	
	
	public List<Customer> findAll() {
		return (List<Customer>) customerRepo.findAll();
	}

	public Customer createMachine(CreateCustomerReq req) {
		req.validateFieldsByType();
		Customer customer = new Customer(req);
		customer = customerRepo.save(customer);

		return customer;
	}

	public Customer modifyMachine(CreateCustomerReq req, UUID id) {
		req.validateFieldsByType();
		Customer customer = findByIdentifier(id);
		customer.setVariablesByDto(req);
		
		return customerRepo.save(customer);
	}

	public Customer findByIdentifier(UUID id) {
		return customerRepo.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Customer not found!"));
	}

	public void deleteById(UUID id) {
		// TODO check for customer has no active machine rent
		customerRepo.deleteById(id);
	}

}
