package com.siar.users.services;

import com.siar.users.models.UserDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    private UserRepository repository;

    public List<UserDTO> getAllUsers() {
        return repository.listAll();
    }

    public UserDTO getByDoc(int docNumber) {
        return null;
    }

    public void saveUser(UserDTO u){
        repository.persist(u);
    }
}
