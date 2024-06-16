package hu.machinerental.machine_microservice.service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.stereotype.Service;

import hu.machinerental.machine_microservice.exception.MachineInRentException;
import hu.machinerental.machine_microservice.feignclients.rental.RentalClient;
import hu.machinerental.machine_microservice.feignclients.rental.dto.Rental;
import hu.machinerental.machine_microservice.model.dto.CreateMachineReq;
import hu.machinerental.machine_microservice.model.entity.Machine;
import hu.machinerental.machine_microservice.repository.MachineRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MachineService {
	
	private final MachineRepository machineRepo;
	private final RentalClient rentalClient;
	
	public List<Machine> findAll() {
		return (List<Machine>) machineRepo.findAll();
	}
	
	public Machine findByIdentifier(UUID id) {
		return machineRepo.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Machine not found with identifier: " + id));
	}

	public Machine createMachine(CreateMachineReq req) {
		Machine machine = new Machine(null, req.getName());
		return machineRepo.save(machine);
	}

	public Machine modifyMachine(@Valid CreateMachineReq req, UUID id) {
		Machine machine = findByIdentifier(id);
		machine.setName(req.getName());
		return machineRepo.save(machine);
	}

	public void deleteById(UUID id) {
		
		List<Rental> activeRentals = rentalClient.findAllFiltered(null, null, LocalDate.now(), null);
		boolean hasRentalById = false;
		
		if(activeRentals != null && !activeRentals.isEmpty()) {
			hasRentalById = activeRentals.stream().anyMatch(r -> id.equals(r.getId()));
		}
		
		if(hasRentalById) {
			throw new MachineInRentException();
		}
		
		machineRepo.deleteById(id);
	}

}
