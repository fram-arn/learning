package com.mitrais.rmsspring.service;

import java.util.Set;

import com.mitrais.rmsspring.model.Privilege;
import com.mitrais.rmsspring.model.Role;

public interface RoleService {
	Set<Role> getRoles();
	void saveRoles(String roleName, Set<Privilege> privileges);
}
