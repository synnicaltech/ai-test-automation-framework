package com.automation.services;

import com.automation.core.exception.FrameworkException;
import org.openqa.selenium.WebDriver;

public class BrowserService {

    private final WebDriver driver;

    public BrowserService(WebDriver driver) {
        if (driver == null) {
            throw new FrameworkException("WebDriver cannot be null.");
        }
        this.driver = driver;
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void back() {
        driver.navigate().back();
    }

    public void forward() {
        driver.navigate().forward();
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
