package ru.praktikum.web.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.praktikum.web.api.model.CreateUserRequest;

public class LogoutTest extends BaseUiTest {

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Возвращение на страницу входа после выхода из аккаунта")
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
