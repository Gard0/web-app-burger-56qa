package ru.praktikum.web.tests;

import org.junit.Assert;
import org.junit.Test;

import ru.praktikum.web.api.model.CreateUserRequest;

public class LogoutTest extends BaseUiTest {

    @Test
    public void shouldLogoutFromProfile() {
        CreateUserRequest user = createUserViaApi();

        loginPage.open();
        loginViaUi(user);
        mainPage.clickPersonalAccountButton();
        profilePage.waitUntilOpened();
        profilePage.clickLogoutButton();

        Assert.assertTrue("После выхода должна открыться страница входа", loginPage.isOpened());
    }
}
