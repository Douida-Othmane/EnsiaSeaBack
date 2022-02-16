package com.example.ensiasea.Service;

import com.example.ensiasea.Entity.User;
import com.example.ensiasea.Exception.ApiRequestException;
import com.example.ensiasea.Repository.UserRepo;


import org.springframework.stereotype.Service;



import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user) {
        try {
            user.setUserCode(UUID.randomUUID().toString());
            return userRepo.save(user);
        } catch (Exception exception) {
            throw new ApiRequestException("Error While Creating User", exception.getMessage());
        }

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

    public org.springframework.security.core.userdetails.User findUserByEmail(String email){
        User user = userRepo.findUserByEmail(email);
        if(user == null){
            throw new ApiRequestException("Error User Not Found");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),null);
    }

    public void deleteUser(Long id) {
        try {
            userRepo.deleteById(id);
        } catch (Exception exception) {
            throw new ApiRequestException("Error While Deleting User", exception.getMessage());
        }

    }

}
