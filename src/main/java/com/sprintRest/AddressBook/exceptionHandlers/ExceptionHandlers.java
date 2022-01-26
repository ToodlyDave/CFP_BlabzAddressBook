package com.sprintRest.AddressBook.exceptionHandlers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sprintRest.AddressBook.dto.ResponseDTO;
import com.sprintRest.AddressBook.exceptions.AddressNotFound;

@ControllerAdvice
public class ExceptionHandlers {
	
	@ExceptionHandler(AddressNotFound.class)
	public ResponseEntity<ResponseDTO> handleAddressNotFound(AddressNotFound error) {
		ResponseDTO response = new ResponseDTO("Invalid address id", error.getMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleInvalidInput(MethodArgumentNotValidException error) {
		List<String> message = error.getAllErrors().stream()
									.map(errorObject -> errorObject.getDefaultMessage())
									.collect(Collectors.toList());
		ResponseDTO response = new ResponseDTO("Invalid input", message);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
	}
}
