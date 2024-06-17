package hu.machinerental.rental_microservice.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import hu.machinerental.rental_microservice.exception.MachineAlreadyRentedException;
import hu.machinerental.rental_microservice.model.dto.CreateRentalDto;
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

	public Rental makeRent(CreateRentalDto req) {
		boolean existsMachineRental = rentalRepo.existsByDateToGreaterThanEqualAndMachineId
				(LocalDate.now(), req.getMachineId());
		
		if(existsMachineRental) {
			throw new MachineAlreadyRentedException();
		}

		Rental rental = new Rental(req);
		
		return rentalRepo.save(rental);
	}

	public void deleteById(UUID id) {
		rentalRepo.deleteById(id);
	}
	
	
}
