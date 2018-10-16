package com.mitrais.rmsspring.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitrais.rmsspring.model.Privilege;
import com.mitrais.rmsspring.model.Role;
import com.mitrais.rmsspring.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleRepository roleRepository;
	@Override
	public Set<Role> getRoles() {
		return new HashSet<>(roleRepository.findAll());
	}
	@Override
	public void saveRoles(String roleName, Set<Privilege> privileges) {
		Role role = new Role();
		role.setName(roleName);
		role.setPrivileges(privileges);
		roleRepository.save(role);
	}
	
}
