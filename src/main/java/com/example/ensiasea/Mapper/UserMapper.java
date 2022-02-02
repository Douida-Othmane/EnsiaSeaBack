package com.example.ensiasea.Mapper;


import com.example.ensiasea.DTO.UserDto;
import com.example.ensiasea.Entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.Optional;

@Mapper
public interface UserMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public void updateUserFromDto(UserDto userDto, @MappingTarget Optional<User> user);
}
