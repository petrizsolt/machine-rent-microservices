package hu.machinerental.rental_microservice.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.machinerental.rental_microservice.model.dto.CreateRentalDto;
import hu.machinerental.rental_microservice.model.entity.Rental;
import hu.machinerental.rental_microservice.service.RentalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/rental")
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class RentalController {
	
	private final RentalService rentalService;
	
	
	@GetMapping
	public List<Rental> findAll() {
		 return rentalService.findAll();
	}
	
	@PostMapping("/rent")
	public Rental rent(@Valid @RequestBody CreateRentalDto req) {
		return rentalService.makeRent(req);
	}
	
	@DeleteMapping("/delete-by-id")
	public void deleteById(@RequestParam UUID id) {
		rentalService.deleteById(id);
	}
	
	@GetMapping("/filtered")
	public List<Rental> findAllFiltered(
			@RequestParam(required = false) Optional<LocalDate> dateFromStart,
			@RequestParam(required = false) Optional<LocalDate> dateFromEnd, 
			@RequestParam(required = false) Optional<LocalDate> dateToStart,
			@RequestParam(required = false) Optional<LocalDate> dateToEnd) {
		 return rentalService.findAllFiltered(dateFromStart, dateFromEnd, dateToStart, dateToEnd);
	}
}
