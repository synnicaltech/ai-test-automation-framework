package com.automation.api.response;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class DefaultApiResponseSpecificationFactory implements ApiResponseSpecificationFactory{

    @Override
    public ResponseSpecification create() {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder.expectContentType(ContentType.JSON);
        return builder.build();
    }

}
