package ru.praktikum.web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikum.web.config.UiConfig;

import java.time.Duration;

public abstract class BasePage {

    private static final By MODAL_OVERLAY = By.cssSelector("div[class*='Modal_modal_overlay']");

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(UiConfig.EXPLICIT_WAIT_SECONDS));
    }

    @Step("Открыть путь {path}")
    protected void open(String path) {
        driver.get(UiConfig.BASE_URL + path);
    }

    protected WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickability(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    @Step("Кликнуть по элементу")
    protected void click(By locator) {
        waitForOverlayToDisappear();
        WebElement element = waitForClickability(locator);
        try {
            element.click();
        } catch (ElementClickInterceptedException exception) {
            waitForOverlayToDisappear();
            scrollIntoView(locator);
            clickWithJavaScript(locator);
        }
    }

    @Step("Заполнить поле значением")
    protected void type(By locator, String value) {
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(value);
    }

    protected String readText(By locator) {
        return waitForVisibility(locator).getText();
    }

    protected boolean isVisible(By locator) {
        try {
            waitForVisibility(locator);
            return true;
        } catch (TimeoutException exception) {
            return false;
        }
    }

    protected void waitForUrlContains(String value) {
        wait.until(ExpectedConditions.urlContains(value));
    }

    protected void scrollIntoView(By locator) {
        WebElement element = waitForVisibility(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    protected void clickWithJavaScript(By locator) {
        WebElement element = waitForVisibility(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    protected void waitForOverlayToDisappear() {
        wait.until(driver -> {
            try {
                return driver.findElements(MODAL_OVERLAY).stream().noneMatch(WebElement::isDisplayed);
            } catch (RuntimeException exception) {
                return true;
            }
        });
    }
}
