package com.automation;

import com.automation.core.config.BrowserConfig;
import com.automation.core.config.ConfigManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigurationTest {

    private static final Logger log = LoggerFactory.getLogger(ConfigurationTest.class);

    @Test
    public void shouldLoadConfiguration(){
        String baseUrl = ConfigManager.get("base.url");
        String gridUrl = ConfigManager.get("remote.url");
        String browser = ConfigManager.get("browser");
        String executionType = ConfigManager.get("execution.type");
        boolean headless = ConfigManager.getBoolean("headless");
        int explicitWait = ConfigManager.getInt("explicit.wait");

        log.info("Base Url : {}",baseUrl);
        log.info("Remote Url: {}", gridUrl);
        log.info("Browser : {}",browser);
        log.info("Headless : {}",headless);
        log.info("Execution Type: {}", executionType);
        log.info("Explicit Wait : {}",explicitWait);

        Assertions.assertNotNull(baseUrl);
        Assertions.assertNotNull(browser);
        Assertions.assertNotNull(executionType);
        Assertions.assertTrue(explicitWait > 0);
    }

    @Test
    public void shouldResolveBrowser(){
        Assertions.assertNotNull(BrowserConfig.getBrowser());
        log.info("Resolved Browser : {}",BrowserConfig.getBrowser());
    }
}
