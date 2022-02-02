package com.example.ensiasea.Service;

import com.example.ensiasea.DTO.UserDto;
import com.example.ensiasea.Entity.User;
import com.example.ensiasea.Exception.UserNotFoundException;
import com.example.ensiasea.Mapper.UserMapper;
import com.example.ensiasea.Repository.UserRepo;
import org.apache.catalina.mapper.Mapper;
import org.mapstruct.control.MappingControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepo userRepo;
    //@Autowired
    UserMapper userMapper;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user) {
        user.setUserCode(UUID.randomUUID().toString());
        return userRepo.save(user);
    }

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    public User updateUser(UserDto userDto) {
        Optional<User> user = userRepo.findUserByUserId(userDto.getUserId());
        userMapper.updateUserFromDto(userDto, user);
        return userRepo.save(user);
    }

//    public void updateCustomer(CustomerDto dto) {
//        Customer myCustomer = repo.findById(dto.id);
//        mapper.updateCustomerFromDto(dto, myCustomer);
//        repo.save(myCustomer);
//    }

    public User findUserById(Long id) {
        return userRepo.findUserByUserId(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));

    }

    public void deleteUser(Long id) {
        userRepo.deleteUserByUserId(id);
    }
}
