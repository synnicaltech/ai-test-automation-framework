package com.automation.base;

import com.automation.core.config.BrowserConfig;
import com.automation.core.context.TestContext;
import com.automation.core.driver.DriverManager;
import com.automation.core.extension.FailureScreenshotExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(FailureScreenshotExtension.class)
public abstract class BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeEach
    public void setUp(org.junit.jupiter.api.TestInfo testInfo){
        log.info("========== Test Setup Started ==========");
        String testName = testInfo.getDisplayName();
        TestContext.setTestName(testName);
        TestContext.setBrowser(BrowserConfig.getBrowser().name());
        String environment = System.getProperty("env", "qa");
        TestContext.setEnvironment(environment);

        log.info("Starting test: {} | thread={} | browser={} | environment={}",
                testName,
                Thread.currentThread().getName(),
                TestContext.getBrowser(),
                TestContext.getEnvironment()
        );
        DriverManager.initDriver();
        log.info("========== Test Setup Completed ==========");
    }

    @AfterEach
    public void tearDown(){
        log.info("========== Test Teardown Started ==========");
        DriverManager.quitDriver();
        log.info("========== Test Teardown Completed ==========");
    }
}
