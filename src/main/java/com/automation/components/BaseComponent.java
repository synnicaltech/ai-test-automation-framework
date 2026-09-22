package com.automation.components;

import com.automation.core.waits.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseComponent {

    protected final WebDriver driver;

    protected final WaitManager wait;

    protected final By root;

    protected BaseComponent(WebDriver driver, By root){
        this.driver = driver;
        this.root = root;
        this.wait = new WaitManager(driver);
    }

    protected WebElement root(){
        return wait.waitForVisibility(root);
    }
}
