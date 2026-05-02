package ru.praktikum.web.tests;

import org.junit.Assert;
import org.junit.Test;

import ru.praktikum.web.api.model.CreateUserRequest;

public class RegistrationTest extends BaseUiTest {

    @Test
    public void shouldRegisterUserSuccessfully() {
        CreateUserRequest user = createRandomUser("Test123!");

        loginPage.open();
        loginPage.clickRegisterLink();
        registerPage.waitUntilOpened();
        registerPage.register(user);

        loginPage.waitUntilOpened();
        Assert.assertTrue("После успешной регистрации должна открыться страница входа", loginPage.isOpened());
        authorizeUserForCleanup(user);
    }

    @Test
    public void shouldShowErrorForShortPassword() {
        CreateUserRequest user = createRandomUser("12345");

        loginPage.open();
        loginPage.clickRegisterLink();
        registerPage.waitUntilOpened();
        registerPage.register(user);

        Assert.assertEquals("Некорректный пароль", registerPage.getPasswordErrorText());
    }
}
