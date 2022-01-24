package com.sprintRest.AddressBook.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.sprintRest.AddressBook.dto.AddressBookDTO;
import com.sprintRest.AddressBook.dto.ResponseDTO;

public interface IAddressBookServices {

	public ResponseEntity<ResponseDTO> hello();

	public ResponseEntity<ResponseDTO> getAddress(Optional<String> id);

	public ResponseEntity<ResponseDTO> createAddress(AddressBookDTO address);

	public ResponseEntity<ResponseDTO> updateAddress(String id, AddressBookDTO address);

	public ResponseEntity<ResponseDTO> deleteAddress(String id);

}
