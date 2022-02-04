package com.example.ensiasea.Controller;

import com.example.ensiasea.Entity.User;
import com.example.ensiasea.Response.UserResponse;
import com.example.ensiasea.Service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<UserResponse> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(
                new UserResponse(true, null, "Getting All Users successfully", users.size(), users, null),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("id") Long id) {

        User user = userService.findUserById(id);
        return new ResponseEntity<>(new UserResponse(true, null, "Getting User successfully", 0, null, user),
                HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UserResponse> addUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>(new UserResponse(true, null, "Creating User successfully", 0, null, user),
                HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<UserResponse> updateUser(@RequestBody User user) {
        User updateUser = userService.updateUser(user);
        return new ResponseEntity<>(new UserResponse(true, null, "Updating User successfully", 0, null, updateUser),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(new UserResponse(true, null, "Deleting User successfully", 0, null, null),
                HttpStatus.OK);
    }
}
