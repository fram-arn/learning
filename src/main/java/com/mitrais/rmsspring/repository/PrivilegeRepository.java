package com.mitrais.rmsspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitrais.rmsspring.model.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
	Privilege findByName(String name);
}
