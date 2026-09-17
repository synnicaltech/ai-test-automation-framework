package com.automation.core.driver;

import com.automation.core.exception.FrameworkException;
import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverManager(){}

    public static void initDriver(){
        if(DRIVER.get() != null){
            throw new FrameworkException("WebDriver is already initialized for this thread : "+Thread.currentThread().getName());
        }
        DRIVER.set(DriverFactory.createDriver());
    }

    public static WebDriver getDriver(){
        WebDriver driver = DRIVER.get();
        if(driver == null){
            throw new FrameworkException("WebDriver is not initialized for this thread : "+Thread.currentThread().getName());
        }
        return driver;
    }

    public static void quitDriver(){
        WebDriver driver = DRIVER.get();
        if(driver != null){
            try {
                driver.quit();
            }finally {
                DRIVER.remove();
            }
        }
    }
}
