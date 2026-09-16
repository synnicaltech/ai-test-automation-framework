package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    private WebDriver webDriver;

    public Login(){
        webDriver = new ChromeDriver();
    }

    public Login open(){
        webDriver.manage().window().maximize();
        webDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        return this;
    }

    public String getCurrentUrl(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return webDriver.getCurrentUrl();
    }

    public void closeDriver(){
        webDriver.quit();
    }
}
