package ru.praktikum.web.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.praktikum.web.api.model.CreateUserRequest;

public class NavigationTest extends BaseUiTest {

    @Test
    @DisplayName("Переход в кабинет")
    @Description("Ожидаем открытие страницы профиля после клика по личному кабинету")
    public void shouldOpenPersonalAccountFromMainPage() {
        CreateUserRequest user = createUserViaApi();

        loginPage.open();
        loginViaUi(user);
        mainPage.clickPersonalAccountButton();

        Assert.assertTrue("После клика по личному кабинету должен открыться профиль", profilePage.isOpened());
    }

    @Test
    @DisplayName("Конструктор по кнопке")
    @Description("Переход в конструктор по кнопке конструктор в профиле")
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
    @DisplayName("Конструктор по логотипу")
    @Description("Переход в конструктор из профиля по клику на лого")
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
