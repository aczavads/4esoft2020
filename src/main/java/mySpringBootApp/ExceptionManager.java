package mySpringBootApp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import mySpringBootApp.livro.NotFoundException;

@ControllerAdvice
public class ExceptionManager {
	
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler({NotFoundException.class})
	public void manage(NotFoundException e) {
		
	}

}
