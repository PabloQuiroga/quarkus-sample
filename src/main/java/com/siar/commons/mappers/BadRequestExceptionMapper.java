package com.siar.commons.mappers;

import com.siar.commons.exceptions.BadRequestCustomException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestCustomException> {
    private static record BadRequestMessage(String message, String details){}

    @Override
    public Response toResponse(BadRequestCustomException e) {
        var error = new BadRequestMessage(e.getMessage(), null);
        log.debug(error.message);
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(error.message)
                .build();
    }
}
