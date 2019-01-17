package com.pawan.jsonwebtokensecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest/secure")
public class JWTAPIController {
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String login(){
		 System.out.print("call LoginController -> signIn +12 ");
		return "Successfully logged in...";
	}

}
