package com.pawan.jsonwebtokensecurity.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pawan.jsonwebtokensecurity.model.User;



@Repository
public interface UserRepository extends CustomUserRepository, JpaRepository<User, Long>{
	
}
