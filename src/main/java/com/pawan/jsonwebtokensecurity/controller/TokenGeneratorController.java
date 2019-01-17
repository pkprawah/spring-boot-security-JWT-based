package com.pawan.jsonwebtokensecurity.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pawan.jsonwebtokensecurity.model.User;
import com.pawan.jsonwebtokensecurity.security.JWTGenerator;

@RestController
@RequestMapping("/generate")
public class TokenGeneratorController {
	
	private JWTGenerator jwtGenerator;
	
	public TokenGeneratorController(JWTGenerator jwtGenerator) {
		super();
		this.jwtGenerator = jwtGenerator;
	}

	@RequestMapping(value = "/token", method = RequestMethod.POST)
	public String generator(@RequestBody User user){
		 System.out.print("call LoginController -> signIn +12 ");
		
		 JWTGenerator jwtgenerator=new JWTGenerator();
		 return jwtgenerator.generate(user);
		  
	}

}
