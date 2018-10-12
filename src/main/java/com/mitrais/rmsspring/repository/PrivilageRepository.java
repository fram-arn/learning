package com.mitrais.rmsspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitrais.rmsspring.model.Privilege;

public interface PrivilageRepository extends JpaRepository<Privilege, Long> {
	Privilege findByName(String name);
}
