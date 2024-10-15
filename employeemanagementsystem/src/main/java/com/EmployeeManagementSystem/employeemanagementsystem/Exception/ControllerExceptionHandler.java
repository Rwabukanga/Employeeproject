package com.EmployeeManagementSystem.employeemanagementsystem.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class ControllerExceptionHandler {

	 @ExceptionHandler(ResourceNotFoundException.class)
	 public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	        HttpStatus.NOT_FOUND.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	  }

	  @ExceptionHandler(Exception.class)
	  public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	        HttpStatus.INTERNAL_SERVER_ERROR.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	  
	  @ExceptionHandler(NameException.class)
	  public ResponseEntity<ErrorMessage> NameExceptionHandler(NameException ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	    	ErrorMessage.InvalidName,
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
	  }
	  
	  @ExceptionHandler(PhoneNumberException.class)
	  public ResponseEntity<ErrorMessage> PhoneNumberException(PhoneNumberException ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	    	ErrorMessage.InvalidPhone,
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
	  }
	  
	  @ExceptionHandler(EmailException.class)
	  public ResponseEntity<ErrorMessage> EmailException(EmailException ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	    	ErrorMessage.InvalidEmail,
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
	  }
	  
	  @ExceptionHandler(NationalIDException.class)
	  public ResponseEntity<ErrorMessage> NationalIDException(NationalIDException ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	    	ErrorMessage.InvalidNationalID,
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
	  }
	  
	  @ExceptionHandler(DateofBirthException.class)
	  public ResponseEntity<ErrorMessage> DateofBirthException(DateofBirthException ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	    	ErrorMessage.InvalidDateofBirth,
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
	  }
}
