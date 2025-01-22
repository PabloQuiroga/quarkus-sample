package com.siar.users.resources;

import com.siar.dto.UserDto;
import com.siar.commons.ValidationsGroups;
import com.siar.users.models.UserEntity;
import com.siar.users.services.UserService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.groups.ConvertGroup;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

@Transactional
@Path("/users")
public class UserResource {

    private static final Logger log = LoggerFactory.getLogger(UserResource.class);

    @Inject
    UserService service;

    //TODO remove. unsafe endpoint
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Return all users if exists")
    public List<UserEntity> getAll(){
        return service.getAllUsers();
    }

    @GET
    @Path("/doc")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Get users by document number if exists")
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
    @Operation(description = "Save a new user")
    @Timeout(value = 500) //value default 1000
    @Retry(retryOn = TimeoutException.class, delay = 100, jitter = 50) //max retry 3 por default
    public Response saveUser(
            @Context UriInfo uriInfo,
            @Valid @ConvertGroup (to = ValidationsGroups.Post.class)
            UserDto dto
    ){
        var entity = service.saveUser(dto);
        UriBuilder path = uriInfo.getAbsolutePathBuilder().path(String.valueOf(entity.getDocNumber()));
        return Response.created(path.build()).build();
    }

    @PUT
    @Path("/{document}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Update a User by document number")
    public Response updateUser(
            @PathParam("document")
            Integer docNumber,
            @Valid @ConvertGroup(to = ValidationsGroups.Put.class)
            UserDto dto){
        var result = service.update(docNumber, dto);
        return Response.ok(result).build();
    }
}
