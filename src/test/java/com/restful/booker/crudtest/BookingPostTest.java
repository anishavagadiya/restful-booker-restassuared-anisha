package com.restful.booker.crudtest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.BaseTest;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class BookingPostTest extends BaseTest {
    @Test
    public void createNewBooking() {

        HashMap<Object, Object> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2023-11-05");
        bookingdates.put("checkout", "2023-11-15");

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("John");
        bookingPojo.setLastname("Walker");
        bookingPojo.setTotalprice(250);
        bookingPojo.setDepositpaid(true);
        bookingPojo.setBookingdates(bookingdates);
        bookingPojo.setAdditionalneeds("Brunch");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 7b1d7b341121699ba0943bed04e9190c049b1988bf29891567ea8ac6cec0406e")
                .body(bookingPojo)
                .when()
                .post("/booking");
        response.then().statusCode(200);
        response.then().time(lessThan(3000L));
        response.prettyPrint();
    }

}
