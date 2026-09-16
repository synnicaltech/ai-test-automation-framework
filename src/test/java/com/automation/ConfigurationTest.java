package com.automation;

import com.automation.core.config.BrowserConfig;
import com.automation.core.config.ConfigManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConfigurationTest {

    @Test
    public void shouldLoadConfiguration(){
        String baseUrl = ConfigManager.get("base.url");
        String browser = ConfigManager.get("browser");
        boolean headless = ConfigManager.getBoolean("headless");
        int explicitWait = ConfigManager.getInt("explicit.wait");

        System.out.println("Base Url : "+baseUrl);
        System.out.println("Browser : "+browser);
        System.out.println("Headless : "+headless);
        System.out.println("Explicit Wait : "+explicitWait);

        Assertions.assertNotNull(baseUrl);
        Assertions.assertNotNull(browser);
        Assertions.assertTrue(explicitWait > 0);
    }

    @Test
    public void shouldResolveBrowser(){
        Assertions.assertNotNull(BrowserConfig.getBrowser());
        System.out.println("Resolved Browser : "+BrowserConfig.getBrowser());
    }
}
