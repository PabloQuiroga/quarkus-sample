package com.siar.users;

import com.siar.users.models.UserEntity;
import com.siar.users.resources.UserResource;
import com.siar.users.services.UserRepository;
import io.quarkus.test.InjectMock;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyInt;

@QuarkusTest
@TestHTTPEndpoint(UserResource.class)
public class UserResourceTest {

    @InjectMock
    UserRepository repository;

    @Test
    public void geAlltUsers_returnsList_test(){
        Mockito.when(repository.listAll()).thenReturn(List.of(setResponseMock()));

        given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("size()", is(1));
    }

    @Test
    public void getByDocNumber_returnsNotFound_test(){
        Mockito.when(repository.findByDocNumber(anyInt())).thenReturn(Optional.empty());
        given()
                .when()
                .queryParam("document", 123)
                .get("/doc")
                .then()
                .statusCode(404);
    }

    private UserEntity setResponseMock(){
        return new UserEntity(
                12345,
                "PabloDanielQuiroga",
                LocalDate.parse("1978-03-04")
        );
    }
}
