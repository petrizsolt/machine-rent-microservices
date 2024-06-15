package hu.machinerental.customer_microservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

}
