package com.siar;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name = "com.siar.test-message")
    String testMessage;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Health check endpoint", description = "Return simple message for test API")
    public String hello() {
        return testMessage;
    }
}
