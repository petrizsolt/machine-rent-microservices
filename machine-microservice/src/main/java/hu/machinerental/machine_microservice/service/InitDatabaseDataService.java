package hu.machinerental.machine_microservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hu.machinerental.machine_microservice.model.entity.Machine;
import hu.machinerental.machine_microservice.repository.MachineRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InitDatabaseDataService {
	private final MachineRepository machineRepo;
	
	@PostConstruct
	private void init() {
		List<Machine> machines = List.of(
				new Machine(null, "Intel Xeon v1"), 
				new Machine(null, "HP elitebook 6655"),
				new Machine(null, "Apple Macbook pro"));
		
		machineRepo.saveAll(machines);
	}
}
