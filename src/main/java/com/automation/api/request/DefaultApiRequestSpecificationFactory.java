package com.automation.api.request;

import com.automation.core.config.ConfigManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class DefaultApiRequestSpecificationFactory implements ApiRequestSpecificationFactory{

    public DefaultApiRequestSpecificationFactory(){}

    @Override
    public RequestSpecification create() {
        String baseUrl = ConfigManager.get("api.base.url");
        String basePath = ConfigManager.get("api.base.path","");
        int connectionTimeout = ConfigManager.getInt("api.connection.timout");
        int socketTimeout = ConfigManager.getInt("api.socket.timout");
        int requestTimeout = ConfigManager.getInt("api.request.timout");

        RequestSpecBuilder builder = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setBasePath(basePath)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setConfig(
                        RestAssuredConfig.config()
                                .httpClient(
                                        HttpClientConfig.httpClientConfig()
                                                .setParam("http.connection.timeout",
                                                        connectionTimeout)
                                                .setParam("http.socket.timeout",
                                                        socketTimeout)
                                                .setParam("http.connection-manage.timput",
                                                        requestTimeout)
                                )
                );
        return builder.build();
    }

}
