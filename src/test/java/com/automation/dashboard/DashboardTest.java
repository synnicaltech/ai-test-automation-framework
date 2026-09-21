package com.automation.dashboard;

import com.automation.base.BaseTest;
import com.automation.core.config.ConfigManager;
import com.automation.core.driver.DriverManager;
import com.automation.pages.DashboardPage;
import com.automation.pages.LoginPage;
import com.automation.testdata.model.LoginTestData;
import com.automation.testdata.provider.LoginTestDataProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DashboardTest extends BaseTest {

    @Test
    public void searchPIM(){
        LoginTestData data = LoginTestDataProvider.validLogin();
        LoginPage loginPage = new LoginPage(DriverManager.getDriver()).open(ConfigManager.get("base.url"));
        DashboardPage dashboardPage = loginPage.login(data.username(), data.password());
        Assertions.assertTrue(dashboardPage.isDashboardPageDisplayed());
        dashboardPage.sidebar().searchMenuItem("PIM").selectItem("PIM");
        dashboardPage.header().openProfile().logout();
    }
}
