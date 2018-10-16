package com.mitrais.rmsspring.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegistrationForm {
	@NotNull
    @Size(min=6, max=50,message="Email or username min 6 and max 50")
    private String username;
    @NotNull
    @Size(min=8, message="Password must minimal 8 characters")
    private String password;
    @NotNull
    @Size(min=8, message="Password must minimal 8 characters")
    private String passwordConfirm;
    @NotNull
    private Long idRole;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
    
    
}
