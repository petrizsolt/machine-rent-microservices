package hu.machinerental.api_gateway_for_frontend.feignclients.machine;

import java.util.List;
import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import hu.machinerental.api_gateway_for_frontend.feignclients.machine.dto.CreateMachineReq;
import hu.machinerental.api_gateway_for_frontend.feignclients.machine.dto.Machine;
import jakarta.validation.Valid;

@FeignClient(name = "MACHINE-MICROSERVICE", path = "/api/machines")
public interface MachinesClient {
	
	@GetMapping
	public List<Machine> findAll();
	
	@GetMapping("/find-by-id")
	public Machine findById(@RequestParam UUID id);
	
	@PostMapping("/create")
	public Machine createMachine(@RequestBody @Valid CreateMachineReq req);
	
	@PutMapping("/modify")
	public Machine modifyMachine(@RequestBody @Valid CreateMachineReq req, @RequestParam UUID id);
	
	@DeleteMapping("/delete-by-id")
	public void deleteById(@RequestParam UUID id);
}
