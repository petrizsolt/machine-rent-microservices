package hu.machinerental.machine_microservice.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@ControllerAdvice
public class CustomControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<ExceptionResponse> handleNoElementFound(RuntimeException ex, WebRequest request) {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
	
	
	@AllArgsConstructor
	@Data
	class ExceptionResponse {

	    private Date timestamp;
	    private String message;
	    private String details;
	}
}
