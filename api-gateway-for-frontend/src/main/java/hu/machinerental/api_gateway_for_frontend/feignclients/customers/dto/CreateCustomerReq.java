package hu.machinerental.api_gateway_for_frontend.feignclients.customers.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerReq {
	
	  private String firstName;
	  
	  private String lastName;
	  
	  private String companyName;
	  
	  @NotNull(message = "Missing field: customer type!")
	  private CustomerType type;

	  @NotNull(message = "Missing field: address!")
	  private String address;

	  @NotNull(message = "Missing field: phone!")
	  private String phone;

}
