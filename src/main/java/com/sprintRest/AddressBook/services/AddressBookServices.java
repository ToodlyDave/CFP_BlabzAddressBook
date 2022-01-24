package com.sprintRest.AddressBook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sprintRest.AddressBook.dto.AddressBookDTO;
import com.sprintRest.AddressBook.dto.ResponseDTO;
import com.sprintRest.AddressBook.entities.AddressBook;

@Service
public class AddressBookServices implements IAddressBookServices {

	List<AddressBook> adBookList = new ArrayList<>();
	long counter = 0;

	private AddressBook findAddress(String idOld) {
		long id = Long.parseLong(idOld);

		for (AddressBook addressBook : adBookList) {
			if (addressBook.id == id)
				return addressBook;
		}
		return null;
	}

	@Override
	public ResponseEntity<ResponseDTO> hello() {
		ResponseDTO response = new ResponseDTO("Hello World!", null);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDTO> getAddress(Optional<String> id) {
		if (id.isEmpty()) {
			ResponseDTO response = new ResponseDTO("Returning the whole table", adBookList);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			ResponseDTO response = new ResponseDTO("Returning a specific address",
					findAddress(id.get()));
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<ResponseDTO> createAddress(AddressBookDTO address) {
		AddressBook newAddressBook = new AddressBook(++counter, address);
		adBookList.add(newAddressBook);
		ResponseDTO response = new ResponseDTO("Inserting a new address record", newAddressBook);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDTO> updateAddress(String id, AddressBookDTO address) {
		AddressBook adBook = findAddress(id);
		adBook.name = address.name;
		adBook.address = address.address;

		ResponseDTO response = new ResponseDTO("Updating an address record", adBook);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDTO> deleteAddress(String id) {
		adBookList.remove(findAddress(id));

		ResponseDTO response = new ResponseDTO("Deleting an address record", null);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
