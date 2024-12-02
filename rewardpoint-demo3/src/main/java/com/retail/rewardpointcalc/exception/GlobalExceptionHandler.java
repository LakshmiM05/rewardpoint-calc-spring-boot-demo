package com.retail.rewardpointcalc.exception;

import java.net.http.HttpHeaders;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.springframework.validation.FieldError;



@ControllerAdvice
public class GlobalExceptionHandler   {

    //@Override
	/*
	 * protected ResponseEntity<Object> handleMethodArgumentNotValid(
	 * MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode
	 * status, WebRequest request) { Map<String, String> validationErrors = new
	 * HashMap<>(); List<ObjectError> validationErrorList =
	 * ex.getBindingResult().getAllErrors();
	 * 
	 * validationErrorList.forEach((error) -> { String fieldName = ((FieldError)
	 * error).getField(); String validationMsg = error.getDefaultMessage();
	 * validationErrors.put(fieldName, validationMsg); }); return new
	 * ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST); }
	 */
	
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception exception,
	                                                                            WebRequest webRequest) {
		 
		   ErrorResponseDto errorResponseDTO = new ErrorResponseDto(
	                webRequest.getDescription(false),
	                HttpStatus.INTERNAL_SERVER_ERROR,
	                HttpStatus.INTERNAL_SERVER_ERROR.value(),
	                exception.getMessage(),
	                LocalDateTime.now()
	        );
	        return new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		 
	 }
	 
	 @ExceptionHandler(NoResourceNotFoundException.class)
	    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(NoResourceNotFoundException exception,
	                                                                                 WebRequest webRequest) {
		 
		 
	        ErrorResponseDto errorResponseDTO = new ErrorResponseDto(
	                webRequest.getDescription(false),
	                HttpStatus.NOT_FOUND,
	                HttpStatus.NOT_FOUND.value(),
	                exception.getMessage(),
	                LocalDateTime.now()
	        );
	        return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
	    }
	 
	 @ExceptionHandler(CustomerAlreadyExistsException.class)
	    public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException exception,
	                                                                                 WebRequest webRequest){
	        ErrorResponseDto errorResponseDTO = new ErrorResponseDto(
	                webRequest.getDescription(false),
	                HttpStatus.BAD_REQUEST,
	                HttpStatus.BAD_REQUEST.value(),
	                exception.getMessage(),
	                LocalDateTime.now()
	        );
	        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
	    }
	 }


