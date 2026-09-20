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

import java.time.Duration;

public final class DriverFactory {

    private DriverFactory(){}

    public static WebDriver createDriver(){
        Browser browser = BrowserConfig.getBrowser();
        WebDriver driver = switch (browser){
            case CHROME -> createCromeDriver();
            case FIREFOX -> createFirefoxDriver();
            case EDGE -> createEdgeDriver();
        };
        configureTimeouts(driver);
        return driver;
    }

    private static WebDriver createCromeDriver(){
        ChromeOptions options = new ChromeOptions();
        if(BrowserConfig.isHeadless()){
            options.addArguments("--headless=new");
        }
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }

    private static WebDriver createFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        if (BrowserConfig.isHeadless()) {
            options.addArguments("-headless");
        }
        return new FirefoxDriver(options);
    }

    private static WebDriver createEdgeDriver() {
        EdgeOptions options = new EdgeOptions();
        if (BrowserConfig.isHeadless()) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--start-maximized");
        return new EdgeDriver(options);
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
