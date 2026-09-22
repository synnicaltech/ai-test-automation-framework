package com.automation.core.driver;

import com.automation.core.config.BrowserConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChromeDriverStrategy implements DriverStrategy {

    private static final Logger log = LoggerFactory.getLogger(ChromeDriverStrategy.class);

    @Override
    public WebDriver createDriver() {
        log.info("Creating ChromeDriver");
        ChromeOptions options = new ChromeOptions();
        if (BrowserConfig.isHeadless()) {
            log.info("Chrome running in headless mode");
            options.addArguments("--headless=new");
        }
        options.addArguments("--start-maximized");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        try {
            return new ChromeDriver(options);
        } catch (Exception e) {
            log.error("Failed to create ChromeDriver", e);
            throw e;
        }
    }
}
