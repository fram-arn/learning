package com.mitrais.rmsspring.service;

import com.mitrais.rmsspring.dto.UserDetailDTO;
import com.mitrais.rmsspring.model.Privilege;
import com.mitrais.rmsspring.model.Role;
import com.mitrais.rmsspring.model.User;
import com.mitrais.rmsspring.repository.RoleRepository;
import com.mitrais.rmsspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = roleRepository.findByName("USER");
        user.setRoles(new HashSet<>(Arrays.asList(role)));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	@Override
	public UserDetailDTO getUserDetail(String username) {
		UserDetailDTO userDetail = new UserDetailDTO();
    	User user = findByUsername(username);
    	userDetail.setUsername(user.getUsername());
    	userDetail.setListRoles(new HashSet<>());
    	userDetail.setListPrivileges(new HashSet<>());
    	for(Role role : user.getRoles()) {
    		userDetail.getListRoles().add(role.getName());
    		for(Privilege privilege : role.getPrivileges()) {
    			userDetail.getListPrivileges().add(privilege.getName());
    		}
    	}
		return userDetail;
	}

	@Override
	public void saveUser(User user, Long idRole) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = roleRepository.findById(idRole).get();
        user.setRoles(new HashSet<>(Arrays.asList(role)));
        userRepository.save(user);
	}

}
