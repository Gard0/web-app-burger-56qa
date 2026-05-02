package ru.praktikum.web.driver;

public enum BrowserType {
    CHROME("chrome"),
    FIREFOX("firefox");

    private final String value;

    BrowserType(String value) {
        this.value = value;
    }

    public static BrowserType from(String browserName) {
        if (browserName == null || browserName.isBlank()) {
            return CHROME;
        }
        for (BrowserType browserType : values()) {
            if (browserType.value.equalsIgnoreCase(browserName.trim())) {
                return browserType;
            }
        }
        throw new IllegalArgumentException(
                "Unsupported browser: " + browserName + ". Supported browsers: chrome, firefox"
        );
    }
}
