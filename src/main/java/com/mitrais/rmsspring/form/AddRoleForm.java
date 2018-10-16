package com.mitrais.rmsspring.form;

import java.util.List;

public class AddRoleForm {
	private String roleName;
	private List<Long> idPrivileges;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<Long> getIdPrivileges() {
		return idPrivileges;
	}
	public void setIdPrivileges(List<Long> idPrivileges) {
		this.idPrivileges = idPrivileges;
	}
	
}
