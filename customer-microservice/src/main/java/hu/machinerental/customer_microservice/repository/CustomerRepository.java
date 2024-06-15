package hu.machinerental.customer_microservice.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import hu.machinerental.customer_microservice.model.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, UUID>{

}
