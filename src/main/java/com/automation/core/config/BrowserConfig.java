package com.automation.core.config;

import com.automation.core.driver.Browser;
import com.automation.core.exception.FrameworkException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class BrowserConfig {

    private static final Logger log = LoggerFactory.getLogger(BrowserConfig.class);

    private BrowserConfig(){}

    public static Browser getBrowser(){
        String browser = ConfigManager.get("browser");
        try{
            return Browser.valueOf(browser.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            log.error("Unsupported browser: {}", browser, e);
            throw new FrameworkException("Unsupported browser: "+browser, e);
        }
    }

    public static boolean isHeadless(){
        return ConfigManager.getBoolean("headless");
    }
}
