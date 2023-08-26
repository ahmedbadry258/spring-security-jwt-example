package com.example.demo.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptions {
	
	
	 @ExceptionHandler(RecordNotFoundException.class)
	  public final ResponseEntity<Object> handleUserNotFoundException(RecordNotFoundException ex, WebRequest request) {
	    List<String> details = new ArrayList<>();
	    details.add(ex.getLocalizedMessage());
	    ErrorResponse error = new ErrorResponse("Record Not Found", details);
	    return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	  }
	 @ExceptionHandler(UsernameNotFoundException.class)
	  public final ResponseEntity<Object> handleUsernameNotFoundException(UsernameNotFoundException ex, WebRequest request) {
	    List<String> details = new ArrayList<>();
	    details.add(ex.getLocalizedMessage());
	    ErrorResponse error = new ErrorResponse("Username Not Found Exception", details);
	    return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	  }
	
	 @ExceptionHandler(Exception.class)
	  public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
	    List<String> details = new ArrayList<>();
	    details.add(ex.getLocalizedMessage());
	    ErrorResponse error = new ErrorResponse("Server Error", details);
	    return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
}
