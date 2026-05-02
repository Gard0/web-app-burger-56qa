package ru.praktikum.web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum.web.api.model.CreateUserRequest;

public class LoginPage extends BasePage {

    private final By title = By.xpath("//h2[text()='Вход']");
    private final By emailInput = By.xpath("//h2[text()='Вход']/ancestor::div[contains(@class,'Auth_login')]//input[@type='text']");
    private final By passwordInput = By.xpath("//input[@type='password']");
    private final By loginButton = By.xpath("//button[text()='Войти']");
    private final By registerLink = By.xpath("//a[text()='Зарегистрироваться']");
    private final By forgotPasswordLink = By.xpath("//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть страницу входа")
    public LoginPage open() {
        open("/login");
        waitForVisibility(title);
        return this;
    }

    @Step("Дождаться открытия страницы входа")
    public LoginPage waitUntilOpened() {
        waitForVisibility(title);
        return this;
    }

    @Step("Заполнить email на странице входа")
    public void setEmail(String email) {
        type(emailInput, email);
    }

    @Step("Заполнить пароль на странице входа")
    public void setPassword(String password) {
        type(passwordInput, password);
    }

    @Step("Нажать кнопку 'Войти'")
    public void clickLoginButton() {
        click(loginButton);
    }

    @Step("Авторизоваться пользователем")
    public void login(CreateUserRequest user) {
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        clickLoginButton();
    }

    @Step("Нажать ссылку 'Зарегистрироваться'")
    public void clickRegisterLink() {
        click(registerLink);
    }

    @Step("Нажать ссылку 'Восстановить пароль'")
    public void clickForgotPasswordLink() {
        click(forgotPasswordLink);
    }

    @Step("Проверить, что страница входа открыта")
    public boolean isOpened() {
        return isVisible(title);
    }
}
