package com.epam.test.impl;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;

/**
 * AbstractAPI.
 *
 * @author Anastasiia_Kovalenko
 */
public abstract class AbstractAPI {

    protected <T> T getWithSuccessCheck(String url, Class<T> clazz) {
        return RestAssured.get(url)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(clazz);
    }
}