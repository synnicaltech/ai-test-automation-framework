package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BaseComponent {

    private final By pageTitle = By.xpath("//div[@class='oxd-topbar-header-title']//h6");

    private final By profileButton = By.xpath("//div[@class='oxd-topbar-header-userarea']//i");

    private final By profileRoot = By.xpath("//div[@class='oxd-topbar-header-userarea']//ul[@class='oxd-dropdown-menu']");

    private final Profile profile;

    public Header(WebDriver driver, By rootLocator){
        super(driver, rootLocator);
        profile = new Profile(driver, profileRoot);
    }

    public String getPageTitle(){
        return root().findElement(pageTitle).getText();
    }

    public Profile openProfile(){
        click(root().findElement(profileButton));
        return profile;
    }

}
