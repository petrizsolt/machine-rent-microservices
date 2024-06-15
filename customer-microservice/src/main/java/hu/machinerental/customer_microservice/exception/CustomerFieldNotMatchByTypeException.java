package hu.machinerental.customer_microservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomerFieldNotMatchByTypeException extends RuntimeException {

	private static final long serialVersionUID = 304816120690522465L;

	public CustomerFieldNotMatchByTypeException() {
		super("Mandatory fields not match by customer type!");
	}
}
