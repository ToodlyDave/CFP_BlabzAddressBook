package com.sprintRest.AddressBook.exceptions;

public class AddressNotFound extends Exception {

	private static final long serialVersionUID = 1L;

	public AddressNotFound(String message) {
		super(message);
	}

}
