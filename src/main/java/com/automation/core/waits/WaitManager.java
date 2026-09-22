package com.automation.core.waits;

import com.automation.core.config.ConfigManager;
import com.automation.core.exception.FrameworkException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public final class WaitManager {

    private static final Logger log = LoggerFactory.getLogger(WaitManager.class);

    private static final ThreadLocal<WaitManager> INSTANCE = new ThreadLocal<>();

    private final WebDriverWait wait;

    private WaitManager(WebDriver driver){
        if(driver == null){
            log.error("WebDriver cannot be null.");
            throw new FrameworkException("WebDriver can not be null");
        }
        int timeout = ConfigManager.getInt("explicit.wait");
        if(timeout <= 0){
            log.error("Explicit wait timeout must be greater than 0.");
            throw new FrameworkException("Explicit wait timeout must be greater than 0");
        }
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public static void init(WebDriver driver){
        INSTANCE.set(new WaitManager(driver));
    }

    public static WaitManager getInstance(){
        WaitManager manager = INSTANCE.get();
        if(manager == null){
            log.error("WaitManager is not initialized for current thread.");
            throw new FrameworkException("WaitManager is not initialized for current thread.");
        }
        return manager;
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

    public static void cleanup(){
        INSTANCE.remove();
    }
}
