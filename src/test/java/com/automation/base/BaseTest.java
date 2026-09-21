package com.automation.base;

import com.automation.core.driver.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeEach
    public void setUp(){
        log.info("========== Test Setup Started ==========");
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
