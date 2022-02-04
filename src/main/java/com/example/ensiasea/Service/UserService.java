package com.example.ensiasea.Service;

import com.example.ensiasea.Entity.User;
import com.example.ensiasea.Exception.ApiRequestException;
import com.example.ensiasea.Exception.UserNotFoundException;
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
        return userRepo.findAll();
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }

    public User findUserById(Long id) {
        return userRepo.findUserByUserId(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public User deleteUser(Long id) {
        User user = findUserById(id);
        userRepo.deleteById(id);
        return user;
    }
}
