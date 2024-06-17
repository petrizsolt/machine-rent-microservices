package hu.machinerental.rental_microservice.model.entity;

import java.time.LocalDate;
import java.util.UUID;

import hu.machinerental.rental_microservice.model.dto.CreateRentalDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rentals")
public class Rental {

	  @Id
	  @GeneratedValue(strategy = GenerationType.UUID)
	  private UUID id;
	  
	  private UUID machineId;
	  
	  private UUID customerId;
	  
	  private LocalDate dateFrom;
	  
	  private LocalDate dateTo;
	  
	  public Rental(CreateRentalDto req) {
		  this.machineId = req.getMachineId();
		  this.customerId = req.getCustomerId();
		  this.dateFrom = req.getDateFrom();
		  this.dateTo = req.getDateTo();
	  }

}
