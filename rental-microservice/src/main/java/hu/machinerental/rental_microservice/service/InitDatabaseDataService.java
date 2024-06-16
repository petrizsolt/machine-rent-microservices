package hu.machinerental.rental_microservice.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import hu.machinerental.rental_microservice.feignclients.customer.CustomersClient;
import hu.machinerental.rental_microservice.feignclients.customer.dto.Customer;
import hu.machinerental.rental_microservice.feignclients.customer.dto.CustomerType;
import hu.machinerental.rental_microservice.feignclients.machine.MachineClient;
import hu.machinerental.rental_microservice.feignclients.machine.dto.Machine;
import hu.machinerental.rental_microservice.model.entity.Rental;
import hu.machinerental.rental_microservice.repository.RentalRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InitDatabaseDataService {
	private final CustomersClient customersClient;
	private final MachineClient machineClient;
	private final RentalRepository rentalRepo;

	@PostConstruct
	public void init() {
		List<Customer> customers = customersClient.findAll();
		Customer customer1 = customers.stream()
				.filter(c -> CustomerType.COMPANY.equals(c.getType()))
				.findFirst().get();
		Customer customer2 = customers.stream()
				.filter(c -> CustomerType.PERSON.equals(c.getType()))
				.findFirst().get();
		
		
		List<Machine> machines = machineClient.findAll();
		
		Rental rental1 = new Rental();
		rental1.setCustomerId(customer1.getId());
		rental1.setDateFrom(LocalDate.of(2024, 1, 15));
		rental1.setDateTo(LocalDate.of(2025, 1, 15));
		rental1.setMachineId(machines.get(0).getId());
		
		
		Rental rental2 = new Rental();
		rental2.setCustomerId(customer2.getId());
		rental2.setDateFrom(LocalDate.of(2024, 3, 18));
		rental2.setDateTo(LocalDate.of(2024, 9, 23));
		rental2.setMachineId(machines.get(1).getId());
		
		//EXPIRED rental
		Rental rental3 = new Rental();
		rental3.setCustomerId(customer1.getId());
		rental3.setDateFrom(LocalDate.of(2023, 3, 18));
		rental3.setDateTo(LocalDate.of(2024, 1, 23));
		rental3.setMachineId(machines.get(1).getId());
		
		rentalRepo.save(rental1);
		rentalRepo.save(rental2);
		rentalRepo.save(rental3);
		
		
	}
}
