package com.restful.booker.testbase;

import com.restful.booker.utils.TestUtils;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class BaseTest extends TestUtils {
    @BeforeClass
    public static void inIt() {

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }

}
