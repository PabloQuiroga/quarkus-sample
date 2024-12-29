package com.siar.users.services;

import com.siar.users.models.UserDTO;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheRepository<UserDTO> {

    public Optional<UserDTO> findByDocNumber(int number){
        return find("docNumber", number).singleResultOptional();
    }
}
