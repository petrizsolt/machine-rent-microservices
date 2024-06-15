package hu.machinerental.machine_microservice.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.machinerental.machine_microservice.model.dto.CreateMachineReq;
import hu.machinerental.machine_microservice.model.entity.Machine;
import hu.machinerental.machine_microservice.service.MachineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/machines")
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class MachinesController {
	
	private final MachineService machineService;
	
	@GetMapping
	public List<Machine> findAll() {
		return machineService.findAll();
	}
	
	@GetMapping("/find-by-id")
	public Machine findByIdeintifier(@RequestParam UUID id) {
		return machineService.findByIdentifier(id);
	}
	
	@PostMapping("/create")
	public Machine createMachine(@RequestBody @Valid CreateMachineReq req) {
		return machineService.createMachine(req);
	}
	
	@PutMapping("/modify")
	public Machine modifyMachine(@RequestBody @Valid CreateMachineReq req, @RequestParam UUID id) {
		return machineService.modifyMachine(req, id);
	}
	
}
