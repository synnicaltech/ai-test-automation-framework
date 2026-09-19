package com.automation.pages;

import com.automation.core.config.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private final By usernameField = By.xpath("//input[@name='username']");

    private final By passwordField = By.xpath("//input[@name='password']");

    private final By loginButton = By.xpath("//button[contains(@class,'orangehrm-login-button') and @type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open(){
        driver.get(ConfigManager.get("base.url"));
        return this;
    }

    public LoginPage enterUsername(String usernameValue){
        type(usernameField, usernameValue);
        return this;
    }

    public LoginPage enterPassword(String passwordValue){
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

}
