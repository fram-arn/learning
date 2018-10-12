package com.mitrais.rmsspring.repository;

import com.mitrais.rmsspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
