package hu.machinerental.customer_microservice.model.entity;

import java.util.UUID;

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

}
