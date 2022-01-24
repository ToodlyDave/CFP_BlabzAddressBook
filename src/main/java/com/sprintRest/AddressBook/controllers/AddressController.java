package com.sprintRest.AddressBook.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.sprintRest.AddressBook.services.IAddressBookServices;

@RestController
@RequestMapping("addressBook")
public class AddressController {
	
	@Autowired
	IAddressBookServices adService;

	@GetMapping(value = { "/", "", "home" })
	public ResponseEntity<ResponseDTO> hello() {
		return adService.hello();
	}

	@GetMapping(value = { "/get/{id}", "/get/", "/get" })
	public ResponseEntity<ResponseDTO> getAddress(@PathVariable Optional<String> id) {
		return adService.getAddress(id);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createAddress(@RequestBody AddressBookDTO address) {
		return adService.createAddress(address);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateAddress(@PathVariable String id, @RequestBody AddressBookDTO address) {
		return adService.updateAddress(id, address);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteAddress(@PathVariable String id) {
		return adService.deleteAddress(id);
	}

}
