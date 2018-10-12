package com.mitrais.rmsspring.controller;

import com.mitrais.rmsspring.dto.UserDetailDTO;
import com.mitrais.rmsspring.form.UserRegistrationForm;
import com.mitrais.rmsspring.model.User;
import com.mitrais.rmsspring.service.UserService;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
    
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(Principal principal, Model model){
    	model.addAttribute("username", principal.getName());
    	//user detail
    	UserDetailDTO userDetail = userService.getUserDetail(principal.getName());
    	model.addAttribute("userDetail", userDetail);
        return "index";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("userForm", new UserRegistrationForm());
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
        userService.saveUser(user);

        return "redirect:/";
    }
}
