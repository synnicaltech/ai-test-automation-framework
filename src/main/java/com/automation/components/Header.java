package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BaseComponent {

    private final By pageTitle = By.xpath("");

    private final By profileButton = By.xpath("");

    public Header(WebDriver driver, By rootLocator){
        super(driver, rootLocator);
    }


}
