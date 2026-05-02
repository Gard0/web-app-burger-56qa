package ru.praktikum.web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {

    private final By title = By.xpath("//h2[text()='Восстановление пароля']");
    private final By loginLink = By.xpath("//a[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Дождаться открытия страницы восстановления пароля")
    public ForgotPasswordPage waitUntilOpened() {
        waitForVisibility(title);
        return this;
    }

    @Step("Нажать ссылку 'Войти' на странице восстановления пароля")
    public void clickLoginLink() {
        click(loginLink);
    }
}
