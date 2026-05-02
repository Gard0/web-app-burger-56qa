package ru.praktikum.web.tests;

import org.junit.Assert;
import org.junit.Test;

import ru.praktikum.web.api.model.CreateUserRequest;

public class NavigationTest extends BaseUiTest {

    @Test
    public void shouldOpenPersonalAccountFromMainPage() {
        CreateUserRequest user = createUserViaApi();

        loginPage.open();
        loginViaUi(user);
        mainPage.clickPersonalAccountButton();

        Assert.assertTrue("После клика по личному кабинету должен открыться профиль", profilePage.isOpened());
    }

    @Test
    public void shouldOpenConstructorFromProfileByConstructorButton() {
        CreateUserRequest user = createUserViaApi();

        loginPage.open();
        loginViaUi(user);
        mainPage.clickPersonalAccountButton();
        profilePage.waitUntilOpened();
        mainPage.clickConstructorButton();

        Assert.assertTrue("После клика по конструктору должна открыться главная страница", mainPage.isConstructorPageOpened());
    }

    @Test
    public void shouldOpenConstructorFromProfileByLogo() {
        CreateUserRequest user = createUserViaApi();

        loginPage.open();
        loginViaUi(user);
        mainPage.clickPersonalAccountButton();
        profilePage.waitUntilOpened();
        mainPage.clickLogo();

        Assert.assertTrue("После клика по логотипу должна открыться главная страница", mainPage.isConstructorPageOpened());
    }
}
