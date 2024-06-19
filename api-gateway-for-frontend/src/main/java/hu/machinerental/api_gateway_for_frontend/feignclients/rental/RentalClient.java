package hu.machinerental.api_gateway_for_frontend.feignclients.rental;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import hu.machinerental.api_gateway_for_frontend.feignclients.rental.dto.CreateRentalDto;
import hu.machinerental.api_gateway_for_frontend.feignclients.rental.dto.Rental;
import jakarta.validation.Valid;

@FeignClient(name = "RENTAL-MICROSERVICE", path = "/api/rental")
public interface RentalClient {
	
	@GetMapping
	public List<Rental> findAll();
	
	@PostMapping("/rent")
	public Rental rent(@Valid @RequestBody CreateRentalDto req);
	
	@DeleteMapping("/delete-by-id")
	public void deleteById(@RequestParam UUID id);
	
	@GetMapping("/filtered")
	public List<Rental> findAllFiltered(
			@RequestParam(required = false) Optional<LocalDate> dateFromStart,
			@RequestParam(required = false) Optional<LocalDate> dateFromEnd, 
			@RequestParam(required = false) Optional<LocalDate> dateToStart,
			@RequestParam(required = false) Optional<LocalDate> dateToEnd);
}
