package hu.machinerental.rental_microservice.feignclients.customer.dto;

import java.util.UUID;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	  private UUID id;

	  private String firstName;
	  
	  private String lastName;
	  
	  private String companyName;
	  
	  private CustomerType type;
	  
	  private String address;
	  
	  private String phone;

}
