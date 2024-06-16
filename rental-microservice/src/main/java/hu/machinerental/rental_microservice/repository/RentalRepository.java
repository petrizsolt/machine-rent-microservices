package hu.machinerental.rental_microservice.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import hu.machinerental.rental_microservice.model.entity.Rental;

public interface RentalRepository extends CrudRepository<Rental, UUID>{

}
