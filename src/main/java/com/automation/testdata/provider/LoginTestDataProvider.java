package com.automation.testdata.provider;

import com.automation.testdata.model.LoginTestData;
import com.automation.testdata.reader.PropertyTestDataReader;

public final class LoginTestDataProvider {

    private static final String FILE = "testdata/login-data.properties";

    private LoginTestDataProvider(){}

    public static LoginTestData validLogin(){
        PropertyTestDataReader reader = new PropertyTestDataReader(FILE);
        return new LoginTestData(reader.get("valid.username"), reader.get("valid.password"));
    }

    public static LoginTestData invalidLogin(){
        PropertyTestDataReader reader = new PropertyTestDataReader(FILE);
        return new LoginTestData(reader.get("invalid.username"), reader.get("invalid.password"));
    }
}
