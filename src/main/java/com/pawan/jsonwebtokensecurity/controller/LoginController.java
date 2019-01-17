package com.pawan.jsonwebtokensecurity.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/access")
public class LoginController {
	
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	@PreAuthorize ("hasRole('ROLE_ADMIN')")
	public String login(){
		 System.out.print("call LoginController -> signIn +12 ");
		return "Successfully logged in...";
	}

}
