package com.siar.users.resources;

import com.siar.mappers.NoSuchElementExceptionMapper;
import com.siar.users.models.UserDTO;
import com.siar.users.services.UserService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@Transactional
@Path("/users")
public class UserResource {

    private static final Logger log = LoggerFactory.getLogger(UserResource.class);

    @Inject
    UserService service;

    //TODO remove. unsafe endpoint
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDTO> getAll(){
        return service.getAllUsers();
    }

    @GET
    @Path("/doc")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByDoc(@QueryParam("document") int docNumber){
        log.debug("get users by doc: {}", docNumber);
        return service.getByDoc(docNumber)
                .map(value -> Response.ok(value).build())
                .orElseThrow(
                        () -> new NoSuchElementException("No hay elementos con el parametro indicado")
                );
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveUser(UserDTO user){
        service.saveUser(user);
        return Response.created(URI.create(user.getFullName())).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") long id, UserDTO u){
        var result = service.update(id, u);
        return Response.ok(result).build();
    }
}
