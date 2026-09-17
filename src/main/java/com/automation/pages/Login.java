package com.automation.pages;

import com.automation.core.config.ConfigManager;
import org.openqa.selenium.WebDriver;

public class Login extends BasePage{

    public Login(WebDriver driver) {
        super(driver);
    }

    public Login open(){
        driver.get(ConfigManager.get("base.url"));
        return this;
    }

    public String getCurrentUrl(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.getCurrentUrl();
    }
}
