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

public class LoginTest extends BaseTest {

    @Test
    public void validLogin(){
        LoginTestData data = LoginTestDataProvider.validLogin();
        LoginPage login = new LoginPage(DriverManager.getDriver()).open(ConfigManager.get("base.url"));
        Assertions.assertTrue(login.isLoginPageDisplayed());
        DashboardPage dashboardPage = login.login(data.username(), data.password());
        Assertions.assertTrue(dashboardPage.isDashboardPageDisplayed());
    }

}
