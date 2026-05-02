package ru.praktikum.web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {

    private final By profileLink = By.xpath("//a[text()='Профиль']");
    private final By logoutButton = By.xpath("//button[text()='Выход']");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Дождаться открытия личного кабинета")
    public ProfilePage waitUntilOpened() {
        waitForVisibility(profileLink);
        waitForUrlContains("/account/profile");
        return this;
    }

    @Step("Нажать кнопку 'Выход'")
    public void clickLogoutButton() {
        click(logoutButton);
    }

    @Step("Проверить, что страница профиля открыта")
    public boolean isOpened() {
        return isVisible(profileLink);
    }
}
