package ru.praktikum.web.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.praktikum.web.api.model.CreateUserRequest;

public class LoginTest extends BaseUiTest {

    @Test
    @DisplayName("Вход с главной")
    @Description("Вход через кнопку на главной странице")
    public void shouldLoginFromMainPage() {
        CreateUserRequest user = createUserViaApi();

        mainPage.open();
        mainPage.clickLoginToAccountButton();
        loginViaUi(user);

        Assert.assertTrue("После входа с главной должен открыться конструктор", mainPage.isConstructorPageOpened());
    }

    @Test
    @DisplayName("Вход через кабинет")
    @Description("Вход через кнопку личного кабинета")
    public void shouldLoginFromPersonalAccountButton() {
        CreateUserRequest user = createUserViaApi();

        mainPage.open();
        mainPage.clickPersonalAccountButton();
        loginViaUi(user);

        Assert.assertTrue("После входа через личный кабинет должен открыться конструктор", mainPage.isConstructorPageOpened());
    }

    @Test
    @DisplayName("Вход из регистрации")
    @Description("Вход через ссылку из формы регистрации")
    public void shouldLoginFromRegistrationForm() {
        CreateUserRequest user = createUserViaApi();

        loginPage.open();
        loginPage.clickRegisterLink();
        registerPage.waitUntilOpened();
        registerPage.clickLoginLink();
        loginViaUi(user);

        Assert.assertTrue("После входа регистрации должен открытся конструктор", mainPage.isConstructorPageOpened());
    }

    @Test
    @DisplayName("Вход из восстановления")
    @Description("Вход через ссылку из формы восстановления пароля")
    public void shouldLoginFromForgotPasswordForm() {
        CreateUserRequest user = createUserViaApi();

        loginPage.open();
        loginPage.clickForgotPasswordLink();
        forgotPasswordPage.waitUntilOpened();
        forgotPasswordPage.clickLoginLink();
        loginViaUi(user);

        Assert.assertTrue("После входа из формы восстановления пароля открывается конструктор", mainPage.isConstructorPageOpened());
    }
}
