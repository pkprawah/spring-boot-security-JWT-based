package com.pawan.jsonwebtokensecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pawan.jsonwebtokensecurity.model.Role;


@Repository
public interface RoleRepository extends CustomRoleRepository,JpaRepository<Role, Long> {

}
