package com.pawan.jsonwebtokensecurity.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pawan.jsonwebtokensecurity.model.Privilege;


@Repository
public interface PrivilegeRepository extends PrivilegeRepositoryCustom, JpaRepository<Privilege, Long> {

}
