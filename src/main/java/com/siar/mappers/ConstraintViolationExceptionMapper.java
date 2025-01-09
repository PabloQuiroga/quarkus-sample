package com.siar.mappers;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException e) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(errorMessage(e))
                .build();
    }

    private JsonObject errorMessage(ConstraintViolationException e) {
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();

        for (ConstraintViolation v : e.getConstraintViolations()) {
            objectBuilder.add(v.getPropertyPath().toString(), v.getMessage());
        }
        return objectBuilder.build();
    }
}
