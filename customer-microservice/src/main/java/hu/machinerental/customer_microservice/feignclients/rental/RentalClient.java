package hu.machinerental.customer_microservice.feignclients.rental;

import java.time.LocalDate;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hu.machinerental.customer_microservice.feignclients.rental.dto.Rental;


@FeignClient("RENTAL-MICROSERVICE")
public interface RentalClient {
	
	@GetMapping("/api/rental/filtered")
	public List<Rental> findAllFiltered(
			@RequestParam(required = false) LocalDate dateFromStart,
			@RequestParam(required = false) LocalDate dateFromEnd, 
			@RequestParam(required = false) LocalDate dateToStart,
			@RequestParam(required = false) LocalDate dateToEnd);
}
