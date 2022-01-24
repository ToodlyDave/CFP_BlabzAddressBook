package com.sprintRest.AddressBook.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintRest.AddressBook.dto.AddressBookDTO;
import com.sprintRest.AddressBook.dto.ResponseDTO;
import com.sprintRest.AddressBook.entities.AddressBook;

@RestController
@RequestMapping("addressBook")
public class AddressController {

	@GetMapping(value = { "/", "", "home" })
	public String hello() {
		return "Hello World!";
	}

	@GetMapping(value = { "/get/{id}", "/get/", "/get" })
	public ResponseEntity<ResponseDTO> getAddress(@PathVariable Optional<String> id) {
		if (id.isEmpty()) {
			ResponseDTO response = new ResponseDTO("Returning the whole table", new AddressBookDTO("david", "india"));
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			ResponseDTO response = new ResponseDTO("Returning a specific address", new AddressBookDTO("david", "india"));
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createAddress(@RequestBody AddressBook address) {
		ResponseDTO response = new ResponseDTO("Inserting a new address record", new AddressBookDTO("david", "india"));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateAddress(@RequestBody AddressBook address) {
		ResponseDTO response = new ResponseDTO("Updating an address record", new AddressBookDTO("david", "india"));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteAddress(@PathVariable String id) {
		ResponseDTO response = new ResponseDTO("Deleting an address record", new AddressBookDTO("david", "india"));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
