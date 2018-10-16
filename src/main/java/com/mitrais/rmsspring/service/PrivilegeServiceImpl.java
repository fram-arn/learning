package com.mitrais.rmsspring.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitrais.rmsspring.model.Privilege;
import com.mitrais.rmsspring.repository.PrivilegeRepository;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {
	@Autowired
	PrivilegeRepository privilegeRepository;
	
	@Override
	public Set<Privilege> getPrivilege() {
		return new HashSet<>(privilegeRepository.findAll());
	}

	@Override
	public Set<Privilege> getPrivilege(List<Long> listPrivilegeId) {
		Set<Privilege> listPrivilege = new HashSet<>();
		for(Long id : listPrivilegeId) {
			listPrivilege.add(privilegeRepository.findById(id).get());
		}
		return listPrivilege;
	}

}
