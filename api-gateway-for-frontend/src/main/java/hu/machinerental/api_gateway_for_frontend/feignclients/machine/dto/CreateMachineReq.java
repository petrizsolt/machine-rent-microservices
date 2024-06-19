package hu.machinerental.api_gateway_for_frontend.feignclients.machine.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMachineReq {
	
	@NotBlank(message = "Machine name missing!")
	private String name;
	
}
