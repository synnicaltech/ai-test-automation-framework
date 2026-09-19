package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private final By dashboardTitle = By.xpath("//div[@class='oxd-topbar-header-title']//h6");

    public DashboardPage(WebDriver driver){
        super(driver);
    }

    public boolean isDashboardPageDisplayed(){
        return isDisplayed(dashboardTitle);
    }
}
