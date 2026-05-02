package ru.praktikum.web.tests;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.praktikum.web.api.model.CreateUserRequest;
import ru.praktikum.web.api.steps.UserSteps;
import ru.praktikum.web.config.UiConfig;
import ru.praktikum.web.driver.BrowserFactory;
import ru.praktikum.web.pages.ForgotPasswordPage;
import ru.praktikum.web.pages.LoginPage;
import ru.praktikum.web.pages.MainPage;
import ru.praktikum.web.pages.ProfilePage;
import ru.praktikum.web.pages.RegisterPage;
import ru.praktikum.web.utils.UserGenerator;

public abstract class BaseUiTest {

    protected final UserSteps userSteps = new UserSteps();
    protected String accessToken;
    protected WebDriver driver;
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected RegisterPage registerPage;
    protected ForgotPasswordPage forgotPasswordPage;
    protected ProfilePage profilePage;

    @Before
    public void setUpBrowser() {
        String browser = System.getProperty("browser", UiConfig.DEFAULT_BROWSER);
        if ("firefox".equalsIgnoreCase(browser)) {
            Assume.assumeTrue(
                    "Firefox is not installed in current environment",
                    UserGenerator.isFirefoxInstalled()
            );
        }
        driver = BrowserFactory.createDriver(browser);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        userSteps.deleteUserIfPossible(accessToken);
    }

    @Step("Создать случайного пользователя с заданным паролем")
    protected CreateUserRequest createRandomUser(String password) {
        return UserGenerator.randomUser(password);
    }

    @Step("Создать пользователя через API и сохранить token для cleanup")
    protected CreateUserRequest createUserViaApi() {
        CreateUserRequest user = userSteps.generateRandomUser();
        accessToken = userSteps.extractAccessToken(userSteps.createUser(user));
        return user;
    }

    @Step("Получить token cleanup для пользователя после UI-регистрации")
    protected void authorizeUserForCleanup(CreateUserRequest user) {
        accessToken = userSteps.extractAccessToken(userSteps.login(user));
    }

    @Step("Войти через страницу логина")
    protected void loginViaUi(CreateUserRequest user) {
        loginPage.waitUntilOpened();
        loginPage.login(user);
    }
}
