package ru.praktikum.web.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class BrowserFactory {

    private BrowserFactory() {
    }

    public static WebDriver createDriver(String browserName) {
        BrowserType browserType = BrowserType.from(browserName);
        switch (browserType) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(buildFirefoxOptions());
            case CHROME:
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(buildChromeOptions());
        }
    }

    private static ChromeOptions buildChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-notifications");
        options.addArguments("--no-sandbox");
        if (Boolean.parseBoolean(System.getProperty("headless", "true"))) {
            options.addArguments("--headless=new");
        }
        return options;
    }

    private static FirefoxOptions buildFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--width=1920");
        options.addArguments("--height=1080");
        if (Boolean.parseBoolean(System.getProperty("headless", "true"))) {
            options.addArguments("-headless");
        }
        return options;
    }
}
