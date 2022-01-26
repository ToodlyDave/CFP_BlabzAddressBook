package com.sprintRest.AddressBook.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddressBookDTO {

	@NotNull(message = "ERROR: Name cannot be null")
	@Pattern(regexp = "^([A-Z][a-zA-Z]{2,}[ ]?)+$", message = "ERROR: Invalid name pattern")
	public String name;
	
	@NotNull(message = "ERROR: Address cannot be null")
	public String address;

}
