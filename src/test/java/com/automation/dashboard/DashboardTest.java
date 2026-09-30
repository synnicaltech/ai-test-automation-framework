package com.automation.dashboard;

import com.automation.base.BaseTest;
import com.automation.core.config.ConfigManager;
import com.automation.core.driver.DriverManager;
import com.automation.pages.DashboardPage;
import com.automation.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashboardTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(DashboardTest.class);

    @Test
    public void searchAndSelectPIM(){
        log.info("Starting test: Search & select PIM.");
        String username = ConfigManager.get("ORANGEHRM_CREDS_USR");
        String password = ConfigManager.get("ORANGEHRM_CREDS_PSW");
        LoginPage loginPage = new LoginPage(DriverManager.getDriver()).open(ConfigManager.get("base.url"));
        DashboardPage dashboardPage = loginPage.login(username, password);
        Assertions.assertTrue(dashboardPage.isDashboardPageDisplayed());
        dashboardPage.sidebar().searchMenuItem("PIM").selectItem("PIM");
        dashboardPage.header().openProfile().logout();
        log.info("Test passed: Search & select PIM.");
    }
}
