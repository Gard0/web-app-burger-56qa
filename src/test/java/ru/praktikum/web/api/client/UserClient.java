package ru.praktikum.web.api.client;

import io.restassured.response.Response;
import ru.praktikum.web.api.model.CreateUserRequest;
import ru.praktikum.web.api.model.LoginRequest;

import static io.restassured.RestAssured.given;

public class UserClient extends BaseClient {

    private static final String REGISTER_PATH = "/api/auth/register";
    private static final String LOGIN_PATH = "/api/auth/login";
    private static final String USER_PATH = "/api/auth/user";

    public Response createUser(CreateUserRequest request) {
        return given()
                .spec(requestSpec())
                .body(request)
                .when()
                .post(REGISTER_PATH);
    }

    public Response login(LoginRequest request) {
        return given()
                .spec(requestSpec())
                .body(request)
                .when()
                .post(LOGIN_PATH);
    }

    public Response deleteUser(String accessToken) {
        return given()
                .spec(authorizedRequestSpec(accessToken))
                .when()
                .delete(USER_PATH);
    }
}
