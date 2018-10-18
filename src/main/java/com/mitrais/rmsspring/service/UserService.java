package com.mitrais.rmsspring.service;

import com.mitrais.rmsspring.dto.UserDetailDTO;
import com.mitrais.rmsspring.model.User;

public interface UserService {
    void saveUser(User user, Long idRole);
    User findByUsername(String username);
    UserDetailDTO getUserDetail(String username);
    
}
