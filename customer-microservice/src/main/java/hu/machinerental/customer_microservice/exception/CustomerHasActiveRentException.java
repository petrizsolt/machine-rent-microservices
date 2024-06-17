package hu.machinerental.customer_microservice.exception;

public class CustomerHasActiveRentException extends RuntimeException {

	private static final long serialVersionUID = -5421399497932744007L;

	public CustomerHasActiveRentException() {
		super("Cutomer has avtive rental!");
	}
	
}
