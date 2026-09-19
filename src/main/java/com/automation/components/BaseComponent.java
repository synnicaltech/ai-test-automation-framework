package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseComponent {

    protected final WebDriver driver;

    protected final By root;

    protected BaseComponent(WebDriver driver, By root){
        this.driver = driver;
        this.root = root;
    }

    protected WebElement find(By locator) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(locator);
    }

    protected void click(WebElement element){
        element.click();
    }

    protected WebElement root(){
        return find(root);
    }
}
