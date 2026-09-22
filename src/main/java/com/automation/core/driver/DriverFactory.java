package com.automation.core.driver;

import com.automation.core.config.BrowserConfig;
import com.automation.core.config.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public final class DriverFactory {

    private static final Logger log = LoggerFactory.getLogger(DriverFactory.class);

    private DriverFactory(){}

    public static WebDriver createDriver(){
        Browser browser = BrowserConfig.getBrowser();
        log.info("Creating WebDriver for browser: {}", browser);
        WebDriver driver = switch (browser){
            case CHROME -> createCromeDriver();
            case FIREFOX -> createFirefoxDriver();
            case EDGE -> createEdgeDriver();
        };
        configureTimeouts(driver);
        return driver;
    }

    private static WebDriver createCromeDriver(){
        log.info("Creating ChromeDriver");
        ChromeOptions options = new ChromeOptions();
        if(BrowserConfig.isHeadless()){
            log.info("Chrome running in headless mode");
            options.addArguments("--headless=new");
        }
        options.addArguments("--start-maximized");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        try {
            return new ChromeDriver(options);
        }catch (Exception e){
            log.error("Failed to create ChromeDriver", e);
            throw e;
        }
    }

    private static WebDriver createFirefoxDriver() {
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

    private static WebDriver createEdgeDriver() {
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

    private static void configureTimeouts(WebDriver driver){
        int pageLoadTimeout = ConfigManager.getInt("page.load.timeout");
        int scriptLoadTimeout = ConfigManager.getInt("script.timeout");
        int implicitWaitTimeout = ConfigManager.getInt("implicit.wait");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(scriptLoadTimeout));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTimeout));
    }
}
