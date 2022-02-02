package com.example.ensiasea.Resource;


import com.example.ensiasea.Entity.User;
import com.example.ensiasea.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) { this.userService = userService;}

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
