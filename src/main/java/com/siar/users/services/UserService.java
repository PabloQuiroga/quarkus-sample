package com.siar.users.services;

import com.siar.users.models.UserDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserService {

    @Inject
    private UserRepository repository;

    //only for beginner test
    public List<UserDTO> getAllUsers() {
        return repository.listAll();
    }

    public Optional<UserDTO> getByDoc(int docNumber) {
        return repository.findByDocNumber(docNumber);
    }

    public void saveUser(UserDTO u){
        repository.persist(u);
    }

    public UserDTO update(long id, UserDTO u) {
        var entity = repository.findById(id);
        entity.setDocNumber(u.getDocNumber());
        entity.setFullName(u.getFullName());
        entity.setBirthdate(u.getBirthdate());
        return entity;
    }
}
