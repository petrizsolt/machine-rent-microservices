package hu.machinerental.machine_microservice.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.stereotype.Service;

import hu.machinerental.machine_microservice.model.dto.CreateMachineReq;
import hu.machinerental.machine_microservice.model.entity.Machine;
import hu.machinerental.machine_microservice.repository.MachineRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MachineService {
	
	private final MachineRepository machineRepo;
	
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

}
