package com.pawan.jsonwebtokensecurity.repository;

import org.springframework.stereotype.Repository;

import com.pawan.jsonwebtokensecurity.model.Privilege;



@Repository
public interface PrivilegeRepositoryCustom {

	Privilege getPrivilegeByPrivilegeName(String privilegeName);
	

}
