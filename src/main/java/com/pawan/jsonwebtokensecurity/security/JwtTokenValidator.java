package com.pawan.jsonwebtokensecurity.security;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pawan.jsonwebtokensecurity.model.Role;
import com.pawan.jsonwebtokensecurity.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtTokenValidator {

	private String secretKey="amazon";
	
	public User validate(String token) {
		User jwtuser=null;
		try{
		Claims body=(Claims)Jwts.parser().setSigningKey(secretKey)
				.parse(token).getBody();
		
		String subject=body.getSubject();
		 jwtuser = new User();
		jwtuser.setUsername(body.getSubject());
		jwtuser.setUserId(Long.parseLong((String)body.get("userId")));
		Role role=(Role)body.get("role");
		jwtuser.setRoles(Arrays.asList(role));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return jwtuser;
		
	}

}
