package com.siar.users.services;

import com.siar.dto.users.UpdateUserDto;
import com.siar.dto.users.UserMapper;
import com.siar.users.models.UserEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@ApplicationScoped
public class UserService {

    @Inject
    private UserRepository repository;

    @Inject
    private UserMapper mapper;

    //only for beginner test
    public List<UserEntity> getAllUsers() {
        return repository.listAll();
    }

    public Optional<UserEntity> getByDoc(int docNumber) {
        return repository.findByDocNumber(docNumber);
    }

    public UserEntity saveUser(UpdateUserDto dto){
        var entity = mapper.fromCreate(dto);
        repository.persist(entity);
        return entity;
    }

    public UserEntity update(Integer docNumber, UpdateUserDto dto) {
        var entity = repository.findByDocNumber(docNumber);
        if (entity.isPresent()) {
            val fromUpdate = mapper.fromUpdate(dto, entity.get());
            repository.persist(fromUpdate);
            return fromUpdate;
        }

        throw new NoSuchElementException("No hay usuario para el dni " + docNumber);
    }
}
