package com.sprintRest.AddressBook.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("addressBook")
public class AddressController {

	@GetMapping(value = {"/", "", "home"})
	public String hello() {
		return "Hello World!";
	}
}
