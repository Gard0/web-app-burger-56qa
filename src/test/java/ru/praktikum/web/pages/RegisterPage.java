package ru.praktikum.web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum.web.api.model.CreateUserRequest;

public class RegisterPage extends BasePage {

    private final By title = By.xpath("//h2[text()='Регистрация']");
    private final By nameInput = By.xpath("(//h2[text()='Регистрация']/ancestor::div[contains(@class,'Auth_login')]//input[@type='text'])[1]");
    private final By emailInput = By.xpath("(//h2[text()='Регистрация']/ancestor::div[contains(@class,'Auth_login')]//input[@type='text'])[2]");
    private final By passwordInput = By.xpath("//input[@type='password']");
    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By loginLink = By.xpath("//a[text()='Войти']");
    private final By passwordError = By.xpath("//p[text()='Некорректный пароль']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Дождаться открытия страницы регистрации")
    public RegisterPage waitUntilOpened() {
        waitForVisibility(title);
        return this;
    }

    @Step("Заполнить имя пользователя")
    public void setName(String name) {
        type(nameInput, name);
    }

    @Step("Заполнить email пользователя")
    public void setEmail(String email) {
        type(emailInput, email);
    }

    @Step("Заполнить пароль пользователя")
    public void setPassword(String password) {
        type(passwordInput, password);
    }

    @Step("Нажать кнопку 'Зарегистрироваться'")
    public void clickRegisterButton() {
        click(registerButton);
    }

    @Step("Зарегистрировать пользователя через UI")
    public void register(CreateUserRequest user) {
        setName(user.getName());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        clickRegisterButton();
    }

    @Step("Нажать ссылку 'Войти' на странице регистрации")
    public void clickLoginLink() {
        click(loginLink);
    }

    @Step("Получить текст ошибки пароля")
    public String getPasswordErrorText() {
        return readText(passwordError);
    }
}
