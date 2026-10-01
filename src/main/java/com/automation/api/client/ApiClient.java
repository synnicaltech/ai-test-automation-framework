package com.automation.api.client;

import io.restassured.response.Response;

import java.util.Map;

public interface ApiClient {

    Response get(String path, Map<String, ?> pathParams, Map<String, ?> queryParams);

    Response post(String path, Object body);

    Response put(String path, Object body);

    Response patch(String path, Object body);

    Response delete(String path);
}
