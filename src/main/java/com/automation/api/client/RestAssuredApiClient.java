package com.automation.api.client;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public final class RestAssuredApiClient implements ApiClient{

    @Override
    public Response get(String path, Map<String, ?> pathParams, Map<String, ?> queryParams) {
        return RestAssured
                .given()
                .pathParams(pathParams == null ? Map.of() : pathParams)
                .queryParams(queryParams == null ? Map.of() : queryParams)
                .when()
                .get(path);
    }

    @Override
    public Response post(String path, Object body) {
        return RestAssured
                .given()
                .body(body)
                .when()
                .post(path);
    }

    @Override
    public Response put(String path, Object body) {
        return RestAssured
                .given()
                .body(body)
                .when()
                .put(path);
    }

    @Override
    public Response patch(String path, Object body) {
        return RestAssured
                .given()
                .body(body)
                .when()
                .patch(path);
    }

    @Override
    public Response delete(String path) {
        return RestAssured
                .given()
                .when()
                .delete(path);
    }
}
