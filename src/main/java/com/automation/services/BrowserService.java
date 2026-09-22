package com.automation.services;

import com.automation.core.exception.FrameworkException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserService {
    private static final Logger log = LoggerFactory.getLogger(BrowserService.class);

    private final WebDriver driver;

    public BrowserService(WebDriver driver) {
        if (driver == null) {
            log.error("WebDriver cannot be null.");
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

    public String getTitle() { return driver.getTitle(); }
}
