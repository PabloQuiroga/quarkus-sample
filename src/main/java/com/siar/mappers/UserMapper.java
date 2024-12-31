package com.siar.mappers;

import com.siar.dto.users.UserDto;
import com.siar.users.models.UserEntity;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class UserMapper {

    public UserEntity fromCreate(UserDto dto){
        var user = new UserEntity();
        user.setDocNumber(dto.docNumber());
        user.setFullName(dto.fullName());
        user.setBirthdate(dto.birthdate());
        return user;
    }

    public UserEntity fromUpdate(UserDto dto, UserEntity user){
        if (dto.fullName() != null) user.setFullName(dto.fullName());
        if (dto.birthdate() != null) user.setBirthdate(dto.birthdate());
        return user;
    }
}
