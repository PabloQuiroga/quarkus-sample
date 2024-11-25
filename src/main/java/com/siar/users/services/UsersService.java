package com.siar.users.services;

import com.siar.users.models.User;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class UsersService {

    public List<User> getAllUsers() {
        return List.of(
                new User(
                        123,
                        "Demo full name",
                        "03/04/1978"
                )
        );
    }

    public User getByDoc(int docNumber) {
        return new User(
                docNumber,
                "Demo full name",
                "03/04/1978"
        );
    }
}
