package com.automation.core.driver;

import com.automation.core.config.BrowserConfig;
import com.automation.core.config.ExecutionConfig;
import com.automation.core.exception.FrameworkException;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URI;

public class RemoteWebDriverStrategy implements DriverStrategy{

    private static final Logger log = LoggerFactory.getLogger(RemoteWebDriverStrategy.class);

    @Override
    public WebDriver createDriver() {
        String browser = BrowserConfig.getBrowser().name().toLowerCase();
        log.info("Creating Remote WebDriver for browser: {}", browser);
        MutableCapabilities capabilities = new MutableCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        try {
            return new RemoteWebDriver(URI.create(ExecutionConfig.getGridURL()).toURL(), capabilities);
        } catch (MalformedURLException e) {
            log.error("Invalid Selenium Grid URL", e);
            throw new FrameworkException("Invalid Selenium Grid URL", e);
        }
    }
}
