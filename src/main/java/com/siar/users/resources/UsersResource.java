package com.siar.users.resources;

import com.siar.users.models.User;
import com.siar.users.services.UsersService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;

@Path("/users")
public class UsersResource {

    @Inject
    UsersService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAll(){
        return service.getAllUsers();
    }

    @GET()
    @Path("/id")
    @Produces(MediaType.APPLICATION_JSON)
    public User getByDoc(@QueryParam("document") int docNumber){
        return Optional.of(docNumber)
                .map(value ->service.getByDoc(value))
                .orElse(null);
    }
}
