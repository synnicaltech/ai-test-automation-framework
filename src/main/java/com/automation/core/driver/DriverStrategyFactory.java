package com.automation.core.driver;

import com.automation.core.config.BrowserConfig;
import com.automation.core.config.ExecutionConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DriverStrategyFactory {

    private static final Logger log = LoggerFactory.getLogger(DriverStrategyFactory.class);

    private DriverStrategyFactory() {}

    public static DriverStrategy getDriverStrategy() {
        ExecutionType executionType = ExecutionConfig.getExecutionType();
        log.info("Selecting Driver Strategy: {}", executionType);
        return switch (executionType){
            case LOCAL -> getLocalDriverStrategy();
            case REMOTE -> getRemoteDriverStrategy();
        };
    }

    private static DriverStrategy getLocalDriverStrategy(){
        Browser browser = BrowserConfig.getBrowser();
        log.info("Creating Local WebDriver for browser: {}", browser);
        return switch (browser) {
            case CHROME -> new ChromeDriverStrategy();
            case FIREFOX -> new FirefoxDriverStrategy();
            case EDGE -> new EdgeDriverStrategy();
        };
    }

    private static DriverStrategy getRemoteDriverStrategy(){
        return new RemoteWebDriverStrategy();
    }
}
