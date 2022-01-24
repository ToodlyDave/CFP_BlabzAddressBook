package com.sprintRest.AddressBook.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sprintRest.AddressBook.dto.AddressBookDTO;
import com.sprintRest.AddressBook.dto.ResponseDTO;

@Service
public class AddressBookServices implements IAddressBookServices{

	@Override
	public ResponseEntity<ResponseDTO> hello() {

		ResponseDTO response = new ResponseDTO("Hello World!", null);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDTO> getAddress(Optional<String> id) {
		if (id.isEmpty()) {
			ResponseDTO response = new ResponseDTO("Returning the whole table", new AddressBookDTO("david", "india"));
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			ResponseDTO response = new ResponseDTO("Returning a specific address", new AddressBookDTO("david", "india"));
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<ResponseDTO> createAddress(AddressBookDTO address) {
		ResponseDTO response = new ResponseDTO("Inserting a new address record", new AddressBookDTO("david", "india"));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDTO> updateAddress(String id, AddressBookDTO address) {
		ResponseDTO response = new ResponseDTO("Updating an address record", new AddressBookDTO("david", "india"));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDTO> deleteAddress(String id) {
		ResponseDTO response = new ResponseDTO("Deleting an address record", new AddressBookDTO("david", "india"));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	
	
}