package com.automation.core.driver;

import com.automation.core.exception.FrameworkException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DriverManager {

    private final static Logger log = LoggerFactory.getLogger(DriverManager.class);

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverManager(){}

    public static void initDriver(){
        if(DRIVER.get() != null){
            log.error("WebDriver is already initialized for this thread");
            throw new FrameworkException("WebDriver is already initialized for this thread : "+Thread.currentThread().getName());
        }
        log.info("Initializing WebDriver for thread: {}", Thread.currentThread().getName());
        DRIVER.set(DriverFactory.createDriver());
        log.info("WebDriver initialized successfully");
    }

    public static WebDriver getDriver(){
        WebDriver driver = DRIVER.get();
        if(driver == null){
            log.error("WebDriver requested but not initialized");
            throw new FrameworkException("WebDriver is not initialized for this thread : "+Thread.currentThread().getName());
        }
        return driver;
    }

    public static void quitDriver(){
        WebDriver driver = DRIVER.get();
        if(driver != null){
            log.info("Quitting WebDriver for thread: {}", Thread.currentThread().getName());
            try {
                driver.quit();
                log.info("WebDriver quit successfully");
            } catch (Exception e) {
                log.error("Failed to quit WebDriver", e);
            }finally {
                DRIVER.remove();
                log.info("WebDriver removed from ThreadLocal");
            }
        }
    }
}
