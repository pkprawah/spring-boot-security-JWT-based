package com.pawan.jsonwebtokensecurity.repository;


import org.springframework.stereotype.Repository;

import com.pawan.jsonwebtokensecurity.model.Role;


@Repository
public interface CustomRoleRepository {
	
	Role getRoleByRoleName(String roleName);
	
	Role getRoleByUsername(String username);
	
	
	

}
