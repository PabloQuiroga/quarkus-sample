package com.siar.users;

import com.siar.users.resources.UserResource;
import com.siar.users.services.UserRepository;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
@TestHTTPEndpoint(UserResource.class)
public class UserResourceTest {

    @Inject
    UserRepository repository;

    @Test
    public void geAlltUsers_returnsList_test(){
        given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("size()", is(0));
    }

    @Test
    public void getByDocNumber_returnsNotFound_test(){
        given()
                .when()
                .queryParam("document", 123)
                .get("/doc")
                .then()
                .statusCode(404);
    }
}
