package ru.praktikum.web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private final By loginToAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By constructorTitle = By.xpath("//h1[contains(text(),'Соберите бургер')]");
    private final By constructorButton = By.xpath("//p[text()='Конструктор']");
    private final By logoButton = By.cssSelector("header a[href='/']");
    private final By bunsTab = By.xpath("//span[text()='Булки']/parent::div");
    private final By saucesTab = By.xpath("//span[text()='Соусы']/parent::div");
    private final By fillingsTab = By.xpath("//span[text()='Начинки']/parent::div");
    private final By bunsSection = By.xpath("//h2[text()='Булки']");
    private final By saucesSection = By.xpath("//h2[text()='Соусы']");
    private final By fillingsSection = By.xpath("//h2[text()='Начинки']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть главную страницу")
    public MainPage open() {
        open("/");
        waitForVisibility(constructorTitle);
        return this;
    }

    @Step("Нажать кнопку 'Войти в аккаунт'")
    public void clickLoginToAccountButton() {
        click(loginToAccountButton);
    }

    @Step("Нажать кнопку 'Личный кабинет'")
    public void clickPersonalAccountButton() {
        click(personalAccountButton);
    }

    @Step("Нажать кнопку 'Конструктор'")
    public void clickConstructorButton() {
        click(constructorButton);
    }

    @Step("Нажать логотип Stellar Burgers")
    public void clickLogo() {
        click(logoButton);
    }

    @Step("Перейти к разделу 'Булки'")
    public void clickBunsTab() {
        scrollIntoView(bunsSection);
        click(bunsTab);
    }

    @Step("Перейти к разделу 'Соусы'")
    public void clickSaucesTab() {
        scrollIntoView(saucesSection);
        click(saucesTab);
    }

    @Step("Перейти к разделу 'Начинки'")
    public void clickFillingsTab() {
        scrollIntoView(fillingsSection);
        click(fillingsTab);
    }

    @Step("Проверить, что открыта главная страница конструктора")
    public boolean isConstructorPageOpened() {
        return isVisible(constructorTitle);
    }

    @Step("Проверить, что вкладка 'Булки' активна")
    public boolean isBunsTabActive() {
        return isVisible(By.xpath("//div[contains(@class,'tab_tab_type_current')]//span[text()='Булки']"));
    }

    @Step("Проверить, что вкладка 'Соусы' активна")
    public boolean isSaucesTabActive() {
        return isVisible(By.xpath("//div[contains(@class,'tab_tab_type_current')]//span[text()='Соусы']"));
    }

    @Step("Проверить, что вкладка 'Начинки' активна")
    public boolean isFillingsTabActive() {
        return isVisible(By.xpath("//div[contains(@class,'tab_tab_type_current')]//span[text()='Начинки']"));
    }
}
