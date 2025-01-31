package com.siar.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

/*
curl http://localhost:8080/q/health/ready
 */
@Readiness
public class ReadinessHealthChecks implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.up("Database connection health check 2");
    }
}
