package com.pawan.jsonwebtokensecurity.security;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pawan.jsonwebtokensecurity.model.Role;
import com.pawan.jsonwebtokensecurity.model.User;
import com.pawan.jsonwebtokensecurity.repository.RoleRepository;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTGenerator {

	
	@Autowired
	private RoleRepository roleRepository;
	
	public String generate(User user) {
		
		System.out.println("User inside the JWTGenerator:: " + user);
		System.out.println("roleRepository inside the JWTGenerator:: " + roleRepository);
		
		Role role = roleRepository.getRoleByUsername(user.getUsername());

		System.out.println("Role inside the JWTGenerator:: " + role);
		System.out.println("RoleName inside the JWTGenerator:: " + role.getRoleName());
		// List<Role> rolelist =(List<Role>)user.getRoles();

		// String roleName=null;

		/*
		 * for(Role role:rolelist){ roleName=role.getRoleName(); }
		 */

		Claims claim = Jwts.claims().setSubject(user.getUsername());
		claim.put("userId", user.getUserId());
		claim.put("role", role.getRoleName());
		return Jwts.builder().setClaims(claim).signWith(SignatureAlgorithm.HS512, "amazon").compact();

	}

}
