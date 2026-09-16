package com.automation.login;

import com.automation.base.BaseTest;
import com.automation.pages.Login;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @Test
    public void openUrlTest(){
        Login login = new Login();
        login.open();
        Assertions.assertTrue(login.getCurrentUrl().trim().contains("/auth/login"));
        login.closeDriver();
    }

}
