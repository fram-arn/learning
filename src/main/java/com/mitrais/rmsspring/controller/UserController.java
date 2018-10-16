package com.mitrais.rmsspring.controller;

import com.mitrais.rmsspring.dto.UserDetailDTO;
import com.mitrais.rmsspring.form.AddRoleForm;
import com.mitrais.rmsspring.form.UserRegistrationForm;
import com.mitrais.rmsspring.model.User;
import com.mitrais.rmsspring.service.PrivilegeService;
import com.mitrais.rmsspring.service.RoleService;
import com.mitrais.rmsspring.service.UserService;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PrivilegeService privilegeService;
    @Autowired
    private RoleService roleService;
    
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(Principal principal, Model model){
    	//user detail
    	UserDetailDTO userDetail = userService.getUserDetail(principal.getName());
    	model.addAttribute("userDetail", userDetail);
        return "index";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("userForm", new UserRegistrationForm());
        model.addAttribute("allRoles", roleService.getRoles());
        return "register";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public String doRegister(@Valid @ModelAttribute("userForm") UserRegistrationForm userForm, BindingResult bindingResult, Model model){
    	
        if (bindingResult.hasErrors()) {
            return "register";
        }
        if(userService.findByUsername(userForm.getUsername()) != null) {
    		bindingResult.addError(new FieldError("username", "username", "Email or username is exist"));
    		return "register";
    	}
        
        //create user
        User user = new User();
        user.setUsername(userForm.getUsername());
        user.setPassword(userForm.getPassword());
        userService.saveUser(user, userForm.getIdRole());

        return "redirect:/";
    }
    
    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    @RequestMapping(value = {"/add-role"}, method = RequestMethod.GET)
    public String addRole(Model model){
        model.addAttribute("roleForm", new AddRoleForm());
        model.addAttribute("listPrivileges", privilegeService.getPrivilege());
        model.addAttribute("listRoles", roleService.getRoles());
        return "add-role";
    }
    
    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    @RequestMapping(value = {"/add-role"}, method = RequestMethod.POST)
    public String addRolePost(@ModelAttribute("roleForm") AddRoleForm roleForm, Model model){
        if(roleForm.getIdPrivileges().size() > 0) {
        	roleService.saveRoles(roleForm.getRoleName(), privilegeService.getPrivilege(roleForm.getIdPrivileges()));
        }
        return "redirect:/add-role";
    }
}
