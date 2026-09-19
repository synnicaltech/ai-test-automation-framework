package com.automation.components;

import com.automation.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Profile extends BaseComponent{

    private final String option = "//ul[@role='menu']//a[text()='%s']";

    public Profile(WebDriver driver, By rootLocator){
        super(driver, rootLocator);
    }

    public LoginPage logout(){
        root().findElement(By.xpath(option.replace("%s","Logout"))).click();
        return new LoginPage(driver);
    }
}
