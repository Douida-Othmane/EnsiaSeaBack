package com.example.ensiasea.Controller;

import com.example.ensiasea.DTO.RoleToUserDTO;
import com.example.ensiasea.Models.Role;

import org.springframework.http.ResponseEntity;
import com.example.ensiasea.Service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/roles")
@AllArgsConstructor
public class RoleController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        return ResponseEntity.ok().body(userService.saveRole(role));
    }

    @PostMapping("/addToUser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserDTO form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

}
