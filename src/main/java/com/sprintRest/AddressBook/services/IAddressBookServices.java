package com.sprintRest.AddressBook.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.sprintRest.AddressBook.dto.AddressBookDTO;
import com.sprintRest.AddressBook.dto.ResponseDTO;
import com.sprintRest.AddressBook.exceptions.AddressNotFound;

public interface IAddressBookServices {

	public ResponseEntity<ResponseDTO> hello();

	public ResponseEntity<ResponseDTO> getAddress(Optional<String> id) throws AddressNotFound;

	public ResponseEntity<ResponseDTO> createAddress(AddressBookDTO address);

	public ResponseEntity<ResponseDTO> updateAddress(String id, AddressBookDTO address) throws AddressNotFound;

	public ResponseEntity<ResponseDTO> deleteAddress(String id) throws AddressNotFound;

}
