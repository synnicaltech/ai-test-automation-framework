package com.automation.core.config;

import com.automation.core.driver.Browser;
import com.automation.core.exception.FrameworkException;

public final class BrowserConfig {

    private BrowserConfig(){}

    public static Browser getBrowser(){
        String browser = ConfigManager.get("browser");
        try{
            return Browser.valueOf(browser.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new FrameworkException("Unsupported browser: "+browser, e);
        }
    }

    public static boolean isHeadless(){
        return ConfigManager.getBoolean("headless");
    }
}
