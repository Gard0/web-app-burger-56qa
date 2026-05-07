package ru.praktikum.web.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.praktikum.web.api.model.CreateUserRequest;

public class RegistrationTest extends BaseUiTest {

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Открытие страницы входа после регистрации")
    public void shouldRegisterUserSuccessfully() {
        CreateUserRequest user = createRandomUser("Test123!");

        loginPage.open();
        loginPage.clickRegisterLink();
        registerPage.waitUntilOpened();
        registerPage.register(user);

        loginPage.waitUntilOpened();
        Assert.assertTrue("После успешной регистрации откроется страница входа", loginPage.isOpened());
        authorizeUserForCleanup(user);
    }

    @Test
    @DisplayName("Ошибка короткого пароля")
    @Description("Ожидаем сообщение о пароле меньше шести символов")
    public void shouldShowErrorForShortPassword() {
        CreateUserRequest user = createRandomUser("12345");

        loginPage.open();
        loginPage.clickRegisterLink();
        registerPage.waitUntilOpened();
        registerPage.register(user);

        Assert.assertEquals("Некорректный пароль", registerPage.getPasswordErrorText());
    }
}
