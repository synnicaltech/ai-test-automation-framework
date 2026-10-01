package com.automation.api.users;

import com.automation.api.client.ApiClient;
import com.automation.api.client.RestAssuredApiClient;
import com.automation.api.service.UserService;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserApiTest {

    @Test
    public void shouldReturnUsers(){
        ApiClient apiClient = new RestAssuredApiClient();
        UserService userService = new UserService(apiClient);
        Response response = userService.getUsers();
        Assertions.assertEquals(200, response.statusCode());
    }
}
