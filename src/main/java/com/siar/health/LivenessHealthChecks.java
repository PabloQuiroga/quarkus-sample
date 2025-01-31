package com.siar.health;

import com.siar.users.resources.UserResource;
import jakarta.inject.Inject;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

/*
curl http://localhost:8080/q/health/live
 */
@Liveness
public class LivenessHealthChecks implements HealthCheck {

    @Inject
    UserResource userResource;

    @Override
    public HealthCheckResponse call() {
        var health = userResource.health();
        return HealthCheckResponse.named("Ping user services")
                .withData("health", health)
                .up()
                .build();
    }
}
