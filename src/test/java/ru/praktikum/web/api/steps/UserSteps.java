package ru.praktikum.web.api.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.praktikum.web.api.client.UserClient;
import ru.praktikum.web.api.model.CreateUserRequest;
import ru.praktikum.web.api.model.LoginRequest;
import ru.praktikum.web.utils.UserGenerator;

public class UserSteps {

    private final UserClient userClient = new UserClient();

    @Step("Сгенерировать уникального пользователя")
    public CreateUserRequest generateRandomUser() {
        return UserGenerator.randomUser();
    }

    @Step("Создать пользователя через API")
    public Response createUser(CreateUserRequest request) {
        return userClient.createUser(request);
    }

    @Step("Авторизовать пользователя через API")
    public Response login(CreateUserRequest request) {
        return userClient.login(new LoginRequest(request.getEmail(), request.getPassword()));
    }

    @Step("Удалить пользователя через API")
    public Response deleteUser(String accessToken) {
        return userClient.deleteUser(accessToken);
    }

    @Step("Удалить пользователя, если token существует")
    public void deleteUserIfPossible(String accessToken) {
        if (accessToken != null && !accessToken.isBlank()) {
            deleteUser(accessToken);
        }
    }

    @Step("Извлечь access token из ответа")
    public String extractAccessToken(Response response) {
        return response.then().extract().path("accessToken");
    }
}
