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

import com.sprintRest.AddressBook.entities.AddressBook;

@RestController
@RequestMapping("addressBook")
public class AddressController {

	@GetMapping(value = { "/", "", "home" })
	public String hello() {
		return "Hello World!";
	}

	@GetMapping(value = { "/get/{id}", "/get/", "/get" })
	public ResponseEntity<String> getAddress(@PathVariable Optional<String> id) {
		if (id.isEmpty()) {
			return new ResponseEntity<String>("Returning the whole table", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Returning a specific address", HttpStatus.OK);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<String> createAddress(@RequestBody AddressBook address) {
		return new ResponseEntity<String>("Inserting a new address record", HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateAddress(@RequestBody AddressBook address) {
		return new ResponseEntity<String>("Updating an address record", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAddress(@PathVariable String id) {
		return new ResponseEntity<String>("Deleting an address record", HttpStatus.OK);
	}

}
