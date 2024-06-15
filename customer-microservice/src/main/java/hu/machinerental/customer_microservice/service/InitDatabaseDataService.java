package hu.machinerental.customer_microservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hu.machinerental.customer_microservice.model.entity.Customer;
import hu.machinerental.customer_microservice.model.entity.CustomerType;
import hu.machinerental.customer_microservice.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InitDatabaseDataService {
	private final CustomerRepository customerRepo;
	
	@PostConstruct
	private void init() {
		List<Customer> customers = List.of(
				new Customer(null, null, null, "Google ltd", 
						CustomerType.COMPANY, "United states", "6546441-222"), 
				new Customer(null, null, null, "LIDL kft", 
						CustomerType.COMPANY, "Debrecen csapó u 25", "11225214"), 
				new Customer(null, "Michael", "Peterson", null, 
						CustomerType.PERSON, "New york longstreet 23", "07442211"),
				new Customer(null, "Szabó", "Gyula", null, 
						CustomerType.PERSON, "Szeged", "064422112"));
		
		customerRepo.saveAll(customers);
	}
}
