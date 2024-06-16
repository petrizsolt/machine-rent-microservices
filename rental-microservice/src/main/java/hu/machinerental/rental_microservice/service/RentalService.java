package hu.machinerental.rental_microservice.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import hu.machinerental.rental_microservice.model.entity.Rental;
import hu.machinerental.rental_microservice.repository.RentalRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RentalService {
	private final RentalRepository rentalRepo;

	public List<Rental> findAll() {
		return (List<Rental>) rentalRepo.findAll();
	}

	public List<Rental> findAllFiltered(
			Optional<LocalDate> dateFromStart, 
			Optional<LocalDate> dateFromEnd,
			Optional<LocalDate> dateToStart,
			Optional<LocalDate> dateToEnd) { 

		return rentalRepo.findAllFilteredByDates(dateFromStart, dateFromEnd, dateToStart, dateToEnd);
	}
	
	
}
