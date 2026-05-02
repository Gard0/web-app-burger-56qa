package ru.praktikum.web.tests;

import org.junit.Assert;
import org.junit.Test;

import ru.praktikum.web.api.model.CreateUserRequest;

public class LoginTest extends BaseUiTest {

    @Test
    public void shouldLoginFromMainPage() {
        CreateUserRequest user = createUserViaApi();

        mainPage.open();
        mainPage.clickLoginToAccountButton();
        loginViaUi(user);

        Assert.assertTrue("После входа с главной должен открыться конструктор", mainPage.isConstructorPageOpened());
    }

    @Test
    public void shouldLoginFromPersonalAccountButton() {
        CreateUserRequest user = createUserViaApi();

        mainPage.open();
        mainPage.clickPersonalAccountButton();
        loginViaUi(user);

        Assert.assertTrue("После входа через личный кабинет должен открыться конструктор", mainPage.isConstructorPageOpened());
    }

    @Test
    public void shouldLoginFromRegistrationForm() {
        CreateUserRequest user = createUserViaApi();

        loginPage.open();
        loginPage.clickRegisterLink();
        registerPage.waitUntilOpened();
        registerPage.clickLoginLink();
        loginViaUi(user);

        Assert.assertTrue("После входа из формы регистрации должен открыться конструктор", mainPage.isConstructorPageOpened());
    }

    @Test
    public void shouldLoginFromForgotPasswordForm() {
        CreateUserRequest user = createUserViaApi();

        loginPage.open();
        loginPage.clickForgotPasswordLink();
        forgotPasswordPage.waitUntilOpened();
        forgotPasswordPage.clickLoginLink();
        loginViaUi(user);

        Assert.assertTrue("После входа из формы восстановления пароля должен открыться конструктор", mainPage.isConstructorPageOpened());
    }
}
