package com.automation.core.driver;

import com.automation.core.config.BrowserConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirefoxDriverStrategy implements DriverStrategy {

    private static final Logger log = LoggerFactory.getLogger(FirefoxDriverStrategy.class);

    @Override
    public WebDriver createDriver() {
        log.info("Creating FirefoxDriver");
        FirefoxOptions options = new FirefoxOptions();
        if (BrowserConfig.isHeadless()) {
            log.info("Firefox running in headless mode");
            options.addArguments("-headless");
        }
        try {
            return new FirefoxDriver(options);
        }catch (Exception e){
            log.error("Failed to create FirefoxDriver", e);
            throw e;
        }
    }
}
