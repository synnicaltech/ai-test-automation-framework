package com.automation.pages;

import com.automation.components.Header;
import com.automation.components.Sidebar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private final By dashboardTitle = By.xpath("//div[@class='oxd-topbar-header-title']//h6");

    private final By headerRoot = By.xpath("//div[@class='oxd-topbar-header']");

    private final By sidebarRoot = By.xpath("//nav[@class='oxd-navbar-nav']//div[@class='oxd-sidepanel-body']");

    private final Header header;

    private final Sidebar sidebar;

    public DashboardPage(WebDriver driver){
        super(driver);
        header = new Header(driver, headerRoot);
        sidebar = new Sidebar(driver, sidebarRoot);
    }

    public boolean isDashboardPageDisplayed(){
        return isDisplayed(dashboardTitle);
    }

    public Header header(){
        return header;
    }

    public Sidebar sidebar(){
        return sidebar;
    }
}
