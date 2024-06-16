package hu.machinerental.rental_microservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.machinerental.rental_microservice.model.entity.Rental;
import hu.machinerental.rental_microservice.repository.RentalRepository;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/rental")
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class RentalController {
	private final RentalRepository rentalRepo;
	
	
	@GetMapping
	public List<Rental> findAll() {
		 return (List<Rental>) rentalRepo.findAll();
	}
}
