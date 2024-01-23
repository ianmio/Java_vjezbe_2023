package exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
	@ExceptionHandler(ApiRequestException.class)
	public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
		var badRequest=HttpStatus.BAD_REQUEST;
		var exception=new ApiException(
				e.getMessage(),
				e,
				badRequest,
				ZonedDateTime.now(ZoneId.of("Z"))
				);
		return new ResponseEntity<>(exception,badRequest);
	}
}