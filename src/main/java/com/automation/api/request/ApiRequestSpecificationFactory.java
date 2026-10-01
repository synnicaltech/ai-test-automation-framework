package com.automation.api.request;

import io.restassured.specification.RequestSpecification;

public interface ApiRequestSpecificationFactory {

    RequestSpecification create();

}
