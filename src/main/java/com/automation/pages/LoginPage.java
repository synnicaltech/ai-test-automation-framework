package com.automation.pages;

import com.automation.core.exception.FrameworkException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends BasePage{

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    private final By usernameField = By.xpath("//input[@name='username']");

    private final By passwordField = By.xpath("//input[@name='password']");

    private final By loginButton = By.xpath("//button[contains(@class,'orangehrm-login-button') and @type='submit']");

    private final By errorMessage = By.xpath("//div[@class='orangehrm-login-error']//p");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open(String url){
        log.info("Opening login page: {}", url);
        try {
            driver.get(url);
            wait.waitForUrlContains("/login");
            log.info("Login page opened successfully");
            return this;
        } catch (Exception e) {
            log.error("Failed to open login page: {}", url, e);
            throw new FrameworkException("Failed to open login page: "+ url, e);
        }
    }

    public LoginPage enterUsername(String usernameValue){
        log.info("Entering username");
        type(usernameField, usernameValue);
        return this;
    }

    public LoginPage enterPassword(String passwordValue){
        log.info("Entering password");
        type(passwordField, passwordValue);
        return this;
    }

    public void clickLogin(){
        log.info("Clicking login button");
        click(loginButton);
        log.info("Login button clicked");
    }

    public DashboardPage login(String usernameValue, String passwordValue) {
        log.info("Starting login operation");
        enterUsername(usernameValue);
        enterPassword(passwordValue);
        clickLogin();
        wait.waitForUrlContains("/dashboard");
        log.info("Login operation completed");
        return new DashboardPage(driver);
    }

    public String getErrorMessage(){
        log.debug("Reading login error message");
        return getText(errorMessage);
    }

    public boolean isLoginPageDisplayed(){
        return isDisplayed(usernameField);
    }
}
