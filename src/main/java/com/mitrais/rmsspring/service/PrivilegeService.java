package com.mitrais.rmsspring.service;

import java.util.List;
import java.util.Set;

import com.mitrais.rmsspring.model.Privilege;

public interface PrivilegeService {
	Set<Privilege> getPrivilege();
	Set<Privilege> getPrivilege(List<Long> listPrivilegeId);
}
