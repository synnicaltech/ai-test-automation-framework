package com.automation.pages;

import com.automation.core.config.ConfigManager;
import org.openqa.selenium.WebDriver;

public class Login {

    private WebDriver webDriver;

    public Login(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public Login open(){
        webDriver.get(ConfigManager.get("base.url"));
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
}
