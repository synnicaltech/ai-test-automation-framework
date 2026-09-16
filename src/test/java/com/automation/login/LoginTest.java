package com.automation.login;

import com.automation.pages.Login;
import org.junit.jupiter.api.Test;

public class LoginTest {

    @Test
    public void openUrlTest(){
        Login login = new Login();
        login.open();
    }

}
