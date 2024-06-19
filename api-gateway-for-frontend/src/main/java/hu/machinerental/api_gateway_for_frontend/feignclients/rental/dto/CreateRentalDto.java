package hu.machinerental.api_gateway_for_frontend.feignclients.rental.dto;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRentalDto {
	
	  @NotNull(message = "missing machineId!")
	  private UUID machineId;
	  
	  @NotNull(message = "missing customerId!")
	  private UUID customerId;
	  
	  @NotNull(message = "missing dateFrom!")
	  private LocalDate dateFrom;
	  
	  @NotNull(message = "missing dateTo!")
	  private LocalDate dateTo;
}
