package com.automation.pages;

import com.automation.core.waits.WaitManager;
import com.automation.services.BrowserService;
import com.automation.services.JavaScriptService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    protected final WebDriver driver;

    protected final WaitManager wait;

    protected final BrowserService browserService;

    protected final JavaScriptService javaScriptService;

    protected BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WaitManager(driver);
        this.browserService = new BrowserService(driver);
        this.javaScriptService = new JavaScriptService(driver);
    }

    protected WebElement find(By locator) {
       return wait.waitForVisibility(locator);
    }

    protected void click(By locator) {
        wait.waitForClickable(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return find(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    protected String getTitle() {
        return driver.getTitle();
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
