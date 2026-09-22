package com.automation.core.driver;

import com.automation.core.config.BrowserConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EdgeDriverStrategy implements DriverStrategy {

    private static final Logger log = LoggerFactory.getLogger(EdgeDriverStrategy.class);

    @Override
    public WebDriver createDriver() {
        log.info("Creating EdgeDriver");
        EdgeOptions options = new EdgeOptions();
        if (BrowserConfig.isHeadless()) {
            log.info("Edge running in headless mode");
            options.addArguments("--headless=new");
        }
        options.addArguments("--start-maximized");
        try {
            return new EdgeDriver(options);
        } catch (Exception e) {
            log.error("Failed to create EdgeDriver", e);
            throw e;
        }
    }
}
