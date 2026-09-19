package com.automation.login;

import com.automation.base.BaseTest;
import com.automation.core.driver.DriverManager;
import com.automation.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @Test
    public void openUrlTest(){
        LoginPage login = new LoginPage(DriverManager.getDriver());
        login.open().login("Admin", "admin123");
        Assertions.assertTrue(DriverManager.getDriver().getCurrentUrl().trim().contains("/dashboard"));
    }

}
