package hu.machinerental.rental_microservice.exception;

public class MachineAlreadyRentedException extends RuntimeException {

	private static final long serialVersionUID = 7011443676997219027L;
	
	public MachineAlreadyRentedException() {
		super("Machine already rented!");
	}

}
