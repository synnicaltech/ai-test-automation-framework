package com.automation.api.service;

import com.automation.api.client.ApiClient;
import io.restassured.response.Response;

import java.util.Map;

public final class UserService {

    private final ApiClient apiClient;

    public UserService(ApiClient apiClient){
        this.apiClient = apiClient;
    }

    public Response getUsers(){
        return apiClient.get("/admin/users", Map.of(), Map.of());
    }
}
