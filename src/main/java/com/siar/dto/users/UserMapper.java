package com.siar.dto.users;

import com.siar.users.models.UserEntity;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class UserMapper {

    public UserEntity fromCreate(UpdateUserDto dto){
        var user = new UserEntity();
        user.setDocNumber(dto.docNumber());
        user.setFullName(dto.fullName());
        user.setBirthdate(dto.birthdate());
        return user;
    }

    public UserEntity fromUpdate(UpdateUserDto dto, UserEntity user){
        user.setDocNumber(dto.docNumber());
        user.setFullName(dto.fullName());
        user.setBirthdate(dto.birthdate());
        return user;
    }
}
