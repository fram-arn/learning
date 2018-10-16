package com.mitrais.rmsspring.model;

import javax.persistence.*;
import java.util.Set;

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
