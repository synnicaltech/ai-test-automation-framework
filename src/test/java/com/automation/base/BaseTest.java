package com.automation.base;

import com.automation.core.driver.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

    @BeforeEach
    public void setUp(){
        System.out.println("Starting test...");
        DriverManager.initDriver();
    }

    @AfterEach
    public void tearDown(){
        System.out.println("Cleaning up test...");
        DriverManager.quitDriver();
    }
}
