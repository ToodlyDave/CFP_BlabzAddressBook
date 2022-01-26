package com.sprintRest.AddressBook.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseDTO {

	String message;
	Object data;

}
