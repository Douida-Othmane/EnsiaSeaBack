package com.example.ensiasea.Controller;



import com.example.ensiasea.Entity.User;
import com.example.ensiasea.Response.UserResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 
@RestController
@RequestMapping("api/v1/authentica")
public class AuthenticaAppController {

    @Autowired
    private UserController userController;
     
    @GetMapping("")
    public ResponseEntity<UserResponse> showSignUpForm(Model model) {
    	model.addAttribute("user", new User());
        return new ResponseEntity<>(new UserResponse(true, null, "Register", 0, null, null),
        HttpStatus.OK);
    }
    
    @PostMapping("")
    public ResponseEntity<String> processRegister(User user) {
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userController.addUser(user);
        return new ResponseEntity<>("Register successfuly", HttpStatus.OK);
    }

}