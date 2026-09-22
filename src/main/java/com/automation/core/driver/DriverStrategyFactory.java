package com.automation.core.driver;

import com.automation.core.config.BrowserConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DriverStrategyFactory {

    private static final Logger log = LoggerFactory.getLogger(DriverStrategyFactory.class);

    private DriverStrategyFactory() {}

    public static DriverStrategy getStrategy() {
        Browser browser = BrowserConfig.getBrowser();
        log.info("Creating WebDriver for browser: {}", browser);
        return switch (browser) {
            case CHROME -> new ChromeDriverStrategy();
            case FIREFOX -> new FirefoxDriverStrategy();
            case EDGE -> new EdgeDriverStrategy();
        };
    }
}
