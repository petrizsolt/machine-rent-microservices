package hu.machinerental.rental_microservice.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import hu.machinerental.rental_microservice.model.entity.Rental;

public interface RentalRepository extends CrudRepository<Rental, UUID> {
	@Query("select rental from Rental rental where "
			+ "(cast(:dateFromStart as date) is null or rental.dateFrom >= :dateFromStart ) and " 
			+ "(cast(:dateFromEnd as date) is null or rental.dateFrom <= :dateFromEnd ) and "
			+ "(cast(:dateToStart as date) is null  or rental.dateTo >= :dateToStart) and "
			+ "(cast(:dateToEnd as date) is null  or rental.dateTo <= :dateToEnd)")
	public List<Rental> findAllFilteredByDates(
			Optional<LocalDate> dateFromStart,
			Optional<LocalDate> dateFromEnd,
			Optional<LocalDate> dateToStart,
			Optional<LocalDate> dateToEnd);
}
