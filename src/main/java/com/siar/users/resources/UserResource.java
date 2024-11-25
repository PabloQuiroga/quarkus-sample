package com.siar.users.resources;

import com.siar.users.models.UserDTO;
import com.siar.users.services.UserService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;

@Transactional
@Path("/users")
public class UserResource {

    @Inject
    UserService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDTO> getAll(){
        return service.getAllUsers();
    }

    @GET()
    @Path("/id")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO getByDoc(@QueryParam("document") int docNumber){
        return Optional.of(docNumber)
                .map(value ->service.getByDoc(value))
                .orElse(null);
    }

    @POST
    public void saveUser(){
        UserDTO u = new UserDTO(
                123,
                "Demo full name",
                "03/04/1978"
        );
        service.saveUser(u);
    }
}
