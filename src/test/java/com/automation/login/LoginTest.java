package com.automation.login;

import com.automation.base.BaseTest;
import com.automation.core.config.ConfigManager;
import com.automation.core.driver.DriverManager;
import com.automation.pages.DashboardPage;
import com.automation.pages.LoginPage;
import com.automation.testdata.model.LoginTestData;
import com.automation.testdata.provider.LoginTestDataProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @Test
    public void validLogin(){
        log.info("Starting test: validLogin");
        LoginTestData data = LoginTestDataProvider.validLogin();
        LoginPage login = new LoginPage(DriverManager.getDriver()).open(ConfigManager.get("base.url"));
        Assertions.assertTrue(login.isLoginPageDisplayed());
        DashboardPage dashboardPage = login.login(data.username(), data.password());
        Assertions.assertTrue(dashboardPage.isDashboardPageDisplayed());
        log.info("Test passed: validLogin");
    }

}
