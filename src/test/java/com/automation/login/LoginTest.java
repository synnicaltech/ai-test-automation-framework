package com.automation.login;

import com.automation.base.BaseTest;
import com.automation.core.driver.DriverManager;
import com.automation.pages.DashboardPage;
import com.automation.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin(){
        LoginPage login = new LoginPage(DriverManager.getDriver()).open();
        Assertions.assertTrue(login.isLoginPageDisplayed());
        DashboardPage dashboardPage = login.login("Admin", "admin123");
        Assertions.assertTrue(dashboardPage.isDashboardPageDisplayed());
    }

}
