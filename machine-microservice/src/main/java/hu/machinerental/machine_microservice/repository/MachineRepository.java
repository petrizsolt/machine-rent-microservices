package hu.machinerental.machine_microservice.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import hu.machinerental.machine_microservice.model.entity.Machine;

public interface MachineRepository extends CrudRepository<Machine, UUID>{

}
