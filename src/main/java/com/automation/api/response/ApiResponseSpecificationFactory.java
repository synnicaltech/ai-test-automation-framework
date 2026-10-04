package com.automation.api.response;

import io.restassured.specification.ResponseSpecification;

public interface ApiResponseSpecificationFactory {

    ResponseSpecification create();
}
