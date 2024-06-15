package hu.machinerental.customer_microservice.model.dto;

import hu.machinerental.customer_microservice.exception.CustomerFieldNotMatchByTypeException;
import hu.machinerental.customer_microservice.model.entity.CustomerType;
import io.micrometer.common.util.StringUtils;
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
	  
	  public void validateFieldsByType() {
		  if(CustomerType.COMPANY.equals(this.type) 
				  && StringUtils.isBlank(this.companyName)) {
			  throw new CustomerFieldNotMatchByTypeException();
		  } else if(CustomerType.PERSON.equals(this.type) 
				  && (StringUtils.isBlank(this.firstName) 
						  || StringUtils.isBlank(this.lastName))) {
			  throw new CustomerFieldNotMatchByTypeException();
		  }
		  
	  }
	  
}
