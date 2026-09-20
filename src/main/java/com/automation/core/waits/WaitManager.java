package com.automation.core.waits;

import com.automation.core.config.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitManager {

    private final WebDriverWait wait;

    public WaitManager(WebDriver driver){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigManager.getInt("explicit.wait")));
    }

    public WebElement waitForPresence(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean waitForInvisibility(By locator) {
        return wait.until( ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public boolean waitForText(By locator,String text) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public boolean waitForUrlContains(String value) {
        return wait.until(ExpectedConditions.urlContains(value));
    }

    public boolean waitForTitleContains(String value) {
        return wait.until(ExpectedConditions.titleContains(value));
    }
}
