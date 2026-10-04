package com.automation.api.smoke;

import com.automation.api.request.ApiRequestSpecificationFactory;
import com.automation.api.request.DefaultApiRequestSpecificationFactory;
import com.automation.api.response.ApiResponseSpecificationFactory;
import com.automation.api.response.DefaultApiResponseSpecificationFactory;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

public class UserApiInfrastructureTest {

    @Test
    public void shouldGetUser(){
        ApiRequestSpecificationFactory requestSpecificationFactory = new DefaultApiRequestSpecificationFactory();
        ApiResponseSpecificationFactory responseSpecificationFactory = new DefaultApiResponseSpecificationFactory();
        RequestSpecification requestSpecification = requestSpecificationFactory.create();
        Response response = RestAssured.given().spec(requestSpecification).when().get("/admin/users");
        response.then().spec(responseSpecificationFactory.create());
        response.then().statusCode(200);
        System.out.println(response.asPrettyString());
    }
}
