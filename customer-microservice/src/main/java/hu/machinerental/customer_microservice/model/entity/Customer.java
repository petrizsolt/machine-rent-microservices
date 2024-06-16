package hu.machinerental.customer_microservice.model.entity;

import java.util.UUID;

import hu.machinerental.customer_microservice.model.dto.CreateCustomerReq;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "customers")
public class Customer {

	  @Id
	  @GeneratedValue(strategy = GenerationType.UUID)
	  private UUID id;

	  private String firstName;
	  
	  private String lastName;
	  
	  private String companyName;
	  
	  @Column(nullable = false)
	  @Enumerated(EnumType.STRING)
	  private CustomerType type;
	  
	  @Column(nullable = false)
	  private String address;
	  
	  @Column(nullable = false)
	  private String phone;

	  public Customer(CreateCustomerReq req) {
		  this.address = req.getAddress();
		  this.companyName = req.getCompanyName();
		  this.firstName = req.getFirstName();
		  this.lastName = req.getLastName();
		  this.phone = req.getPhone();
		  this.type = req.getType();
	  }
	  
	  public void setVariablesByDto(CreateCustomerReq req) {
		  this.address = req.getAddress();
		  this.companyName = req.getCompanyName();
		  this.firstName = req.getFirstName();
		  this.lastName = req.getLastName();
		  this.phone = req.getPhone();
		  this.type = req.getType();
	  }
}
