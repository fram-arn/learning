package com.mitrais.rmsspring.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "privilege")
@SequenceGenerator(name="priv_seq", initialValue = 300)
public class Privilege {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="priv_seq")
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "privileges")
    private Set<Role> roles;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
