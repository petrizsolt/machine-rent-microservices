package hu.machinerental.machine_microservice.model.entity;

import java.util.UUID;

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
@Table(name = "machines")
public class Machine {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.UUID)
	  private UUID id;
	  
	  private String name;
}
