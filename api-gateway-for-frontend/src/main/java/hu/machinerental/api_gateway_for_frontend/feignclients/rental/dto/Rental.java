package hu.machinerental.api_gateway_for_frontend.feignclients.rental.dto;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rental {

	  private UUID id;
	  
	  private UUID machineId;
	  
	  private UUID customerId;
	  
	  private LocalDate dateFrom;
	  
	  private LocalDate dateTo;
}
