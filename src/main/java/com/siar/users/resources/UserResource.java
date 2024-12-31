package com.siar.users.resources;

import com.siar.dto.users.UserDto;
import com.siar.commons.ValidationsGroups;
import com.siar.users.models.UserEntity;
import com.siar.users.services.UserService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.groups.ConvertGroup;
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
    public List<UserEntity> getAll(){
        return service.getAllUsers();
    }

    @GET
    @Path("/doc")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByDoc(@QueryParam("document") Integer docNumber){
        log.debug("get users by doc: {}", docNumber);
        return service.getByDoc(docNumber)
                .map(value -> Response.ok(value).build())
                .orElseThrow(
                        () -> new NoSuchElementException("No hay elementos con el parametro indicado")
                );
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveUser(
            @ConvertGroup (to = ValidationsGroups.Post.class)
            @Valid
            UserDto dto
    ){
        var entity = service.saveUser(dto);
        return Response.created(URI.create(String.valueOf(entity.getDocNumber()))).build();
    }

    @PUT
    @Path("/{document}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(
            @PathParam("document")
            Integer docNumber,
            @ConvertGroup (to = ValidationsGroups.Put.class)
            @Valid
            UserDto dto){
        var result = service.update(docNumber, dto);
        return Response.ok(result).build();
    }
}
