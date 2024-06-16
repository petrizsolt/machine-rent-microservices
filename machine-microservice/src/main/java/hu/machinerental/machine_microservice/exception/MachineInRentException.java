package hu.machinerental.machine_microservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MachineInRentException extends RuntimeException {

	private static final long serialVersionUID = 1417847534130498224L;

	public MachineInRentException() {
		super("Machine currently rented!");
	}
}
