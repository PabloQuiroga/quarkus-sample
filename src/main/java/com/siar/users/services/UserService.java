package com.siar.users.services;

import com.siar.dto.UserDto;
import com.siar.commons.mappers.UserMapper;
import com.siar.commons.exceptions.BadRequestCustomException;
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

    public UserEntity saveUser(UserDto dto){
        if(repository.findByDocNumber(dto.docNumber()).isEmpty()) {
            var entity = mapper.fromCreate(dto);
            repository.persist(entity);
            return entity;
        }

        throw new BadRequestCustomException("imposible registrar la nueva entidad");
    }

    public UserEntity update(Integer docNumber, UserDto dto) {
        var entity = repository.findByDocNumber(docNumber);
        if (entity.isPresent()) {
            val fromUpdate = mapper.fromUpdate(dto, entity.get());
            repository.persist(fromUpdate);
            return fromUpdate;
        }

        throw new NoSuchElementException("No hay usuario para el dni " + docNumber);
    }
}
