package com.automation.pages;

import com.automation.core.config.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends BasePage{

    private final By usernameField = By.xpath("//input[@name='username']");

    private final By passwordField = By.xpath("//input[@name='password']");

    private final By loginButton = By.xpath("//button[contains(@class,'orangehrm-login-button') and @type='submit']");

    public Login(WebDriver driver) {
        super(driver);
    }

    public Login open(){
        driver.get(ConfigManager.get("base.url"));
        return this;
    }

    public Login enterUsername(String usernameValue){
        type(usernameField, usernameValue);
        return this;
    }

    public Login enterPassword(String passwordValue){
        type(passwordField, passwordValue);
        return this;
    }

    public void clickLogin(){
        click(loginButton);
    }

    public void login(String usernameValue, String passwordValue){
        enterUsername(usernameValue);
        enterPassword(passwordValue);
        clickLogin();
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
