package com.example.ensiasea.Service;

import com.example.ensiasea.Exception.ApiRequestException;
import com.example.ensiasea.Models.Role;
import com.example.ensiasea.Models.User;
import com.example.ensiasea.Repository.RoleRepo;
import com.example.ensiasea.Repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName().toString()));
        });
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                authorities);
    }

    public User addUser(User user) {
        try {
            user.setUserCode(UUID.randomUUID().toString());
            return this.saveUser(user);
        } catch (Exception exception) {
            throw new ApiRequestException("Error While Creating User", exception.getMessage());
        }

    }

    public User register(User user) {
        try {
            user.setUserCode(UUID.randomUUID().toString());
            return this.saveUser(user);
        } catch (Exception exception) {
            throw new ApiRequestException("Error While registering User", exception.getMessage());
        }
    }

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public List<User> findAllUsers() {
        try {
            return userRepo.findAll();
        } catch (Exception exception) {
            throw new ApiRequestException("Error While Getting All Users", exception.getMessage());
        }
    }

    public User updateUser(User user) {
        try {
            return userRepo.save(user);
        } catch (Exception exception) {
            throw new ApiRequestException("Error While Updating User", exception.getMessage());
        }
    }

    public User findUserById(Long id) {
        return userRepo.findUserByUserId(id)
                .orElseThrow(() -> new ApiRequestException("Error User Not Found"));
    }

    // public org.springframework.security.core.userdetails.User
    // findUserByEmail(String email) {
    // User user = userRepo.findUserByEmail(email);
    // if (user == null) {
    // throw new ApiRequestException("Error User Not Found");
    // }
    // return new
    // org.springframework.security.core.userdetails.User(user.getEmail(),
    // user.getPassword(), null);
    // }

    public void deleteUser(Long id) {
        try {
            userRepo.deleteById(id);
        } catch (Exception exception) {
            throw new ApiRequestException("Error While Deleting User", exception.getMessage());
        }

    }

    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    public void addRoleToUser(String username, String roleName) {
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByRoleName(roleName);
        user.getRoles().add(role);
        userRepo.save(user);
    }

}
