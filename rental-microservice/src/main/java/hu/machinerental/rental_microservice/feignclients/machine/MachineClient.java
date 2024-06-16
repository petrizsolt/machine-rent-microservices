package hu.machinerental.rental_microservice.feignclients.machine;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import hu.machinerental.rental_microservice.feignclients.machine.dto.Machine;

@FeignClient("MACHINE-MICROSERVICE")
public interface MachineClient {
	
	@GetMapping("/api/machines")
	List<Machine> findAll();
}
