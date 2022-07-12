package bankAccount.errorHandling;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler {

	private String NOT_FOUND = "NOT_FOUND";
	private String BAD_REQUEST = "BAD_REQUEST";

	@ExceptionHandler(NotFoundException.class)
	public @ResponseBody ResponseEntity<Error> handleNotFoundException(NotFoundException ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		Error error = new Error(NOT_FOUND, details);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BadRequestException.class)
	public @ResponseBody ResponseEntity<Error> handleBadRequestException(BadRequestException ex,
			WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		Error error = new Error(BAD_REQUEST, details);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	/*@ExceptionHandler(value = RuntimeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody String handleException(RuntimeException ex) {
		return ex.getMessage();
	}*/

}
