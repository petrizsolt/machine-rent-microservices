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

import hu.machinerental.api_gateway_for_frontend.feignclients.machine.MachinesClient;
import hu.machinerental.api_gateway_for_frontend.feignclients.machine.dto.CreateMachineReq;
import hu.machinerental.api_gateway_for_frontend.feignclients.machine.dto.Machine;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/machines")
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class MachinesController {
	
	private final MachinesClient machinesClient;
	
	@GetMapping
	public List<Machine> findAll() {
		return machinesClient.findAll();
	}

	@GetMapping("/find-by-id")
	public Machine findById(@RequestParam UUID id) {
		return machinesClient.findById(id);
	}
	
	@PostMapping("/create")
	public Machine createMachine(@RequestBody @Valid CreateMachineReq req) {
		return machinesClient.createMachine(req);
	}
	
	@PutMapping("/modify")
	public Machine modifyMachine(@RequestBody @Valid CreateMachineReq req, @RequestParam UUID id) {
		return machinesClient.modifyMachine(req, id);
	}
	
	@DeleteMapping("/delete-by-id")
	public void deleteById(@RequestParam UUID id) {
		machinesClient.deleteById(id);
	}
}