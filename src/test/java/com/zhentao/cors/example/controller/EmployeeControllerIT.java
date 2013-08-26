package com.zhentao.cors.example.controller;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import org.junit.Test;

public class EmployeeControllerIT {

    @Test
    public void endpointGetWithUnusedIdProduces404() {
        expect().statusCode(404).body(containsString("100 doesn't exist")).when().get("/rest/employee/100");
    }

    @Test
    public void endpointPutWithUnusedIdProduces204() {
        given().header("Accept", "application/json").contentType("application/json")
                                        .body("{\"id\":\"100\",\"name\":\"Irina\"}").expect().statusCode(204).when()
                                        .put("/rest/employee/100");
    }

    @Test
    public void endpointPutWithMismatchedIdProduces409() {
        given().header("Accept", "application/json").contentType("application/json")
                                        .body("{\"id\":\"172\",\"name\":\"Irina\"}").expect().statusCode(409).when()
                                        .put("/rest/employee/46");
    }

    @Test
    public void endpointPostJsonCorrectlyCreatesEmployeeAndProduces201() {
        given().header("Accept", "application/json").contentType("application/json")
                                        .body("{\"id\":\"9\",\"name\":\"Irina\"}").expect().statusCode(201)
                                        .header("Location", "http://localhost:8080/rest/employee/9").contentType("")
                                        .when().post("/rest/employee");

        expect().statusCode(200).contentType("application/json")
                                        .body(containsString("\"id\":9")).when().get("/rest/employee/9");
    }
}
