package com.sprintRest.AddressBook.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.sprintRest.AddressBook.exceptions.AddressNotFound;
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
	public ResponseEntity<ResponseDTO> getAddress(@PathVariable Optional<String> id) throws AddressNotFound {
		return adService.getAddress(id);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createAddress(@Valid @RequestBody AddressBookDTO address) {
		return adService.createAddress(address);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateAddress(@PathVariable String id, @Valid @RequestBody AddressBookDTO address) throws AddressNotFound {
		return adService.updateAddress(id, address);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteAddress(@PathVariable String id) throws AddressNotFound {
		return adService.deleteAddress(id);
	}

}
