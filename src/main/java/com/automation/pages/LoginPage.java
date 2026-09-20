package com.automation.pages;

import com.automation.core.config.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private final By usernameField = By.xpath("//input[@name='username']");

    private final By passwordField = By.xpath("//input[@name='password']");

    private final By loginButton = By.xpath("//button[contains(@class,'orangehrm-login-button') and @type='submit']");

    private final By errorMessage = By.xpath("//div[@class='orangehrm-login-error']//p");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open(String url){
        driver.get(url);
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

    public DashboardPage clickLogin(){
        click(loginButton);
        return new DashboardPage(driver);
    }

    public DashboardPage login(String usernameValue, String passwordValue) {
        enterUsername(usernameValue);
        enterPassword(passwordValue);
        return clickLogin();
    }

    public String getErrorMessage(){
        return getText(errorMessage);
    }

    public boolean isLoginPageDisplayed(){
        return isDisplayed(usernameField);
    }
}
