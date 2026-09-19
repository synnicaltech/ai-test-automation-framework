package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Sidebar extends BaseComponent{

    private final By searchField = By.xpath("//div[@class='oxd-main-menu-search']//input[@placeholder='Search']");

    private final String manuItem = "//li[@class='oxd-main-menu-item-wrapper']//span[text()='%s']/parent::a";

    public Sidebar(WebDriver driver, By root){
        super(driver, root);
    }

    public Sidebar searchMenuItem(String text){
        WebElement searchFieldElement = root().findElement(searchField);
        searchFieldElement.click();
        searchFieldElement.sendKeys(text);
        return this;
    }

    public void selectItem(String text){
       WebElement item = root().findElement(By.xpath(manuItem.replace("%s", text)));
       item.click();
    }
}
