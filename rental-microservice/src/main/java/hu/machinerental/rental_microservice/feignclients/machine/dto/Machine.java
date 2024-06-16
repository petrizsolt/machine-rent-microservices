package hu.machinerental.rental_microservice.feignclients.machine.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Machine {

	  private UUID id;

	  private String name;
}
