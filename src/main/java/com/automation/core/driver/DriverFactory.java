package com.automation.core.driver;

import com.automation.core.config.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public final class DriverFactory {

    private static final Logger log = LoggerFactory.getLogger(DriverFactory.class);

    private DriverFactory(){}

    public static WebDriver createDriver(){
        DriverStrategy strategy = DriverStrategyFactory.getDriverStrategy();
        WebDriver driver = strategy.createDriver();
        configureTimeouts(driver);
        return driver;
    }

    private static void configureTimeouts(WebDriver driver){
        int pageLoadTimeout = ConfigManager.getInt("page.load.timeout");
        int scriptLoadTimeout = ConfigManager.getInt("script.timeout");
        int implicitWaitTimeout = ConfigManager.getInt("implicit.wait");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(scriptLoadTimeout));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTimeout));
    }
}
