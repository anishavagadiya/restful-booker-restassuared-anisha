package com.restful.booker.crudtest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.BaseTest;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class BookingPutTest extends BaseTest {
    @Test
    public void updateBooking() {

        HashMap<Object, Object> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2023-11-05");
        bookingdates.put("checkout", "2023-11-15");

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("roi");
        bookingPojo.setLastname("Wong");
        bookingPojo.setTotalprice(145);
        bookingPojo.setDepositpaid(false);
        bookingPojo.setBookingdates(bookingdates);
        bookingPojo.setAdditionalneeds("Breakfast");

        Response response = given()
               .header("Authorization", "Bearer 7b1d7b341121699ba0943bed04e9190c049b1988bf29891567ea8ac6cec0406e")
                .header("Content-Type", "application/json")
                .header("Cookie",  "toke: 053719487e6e814")
                .pathParam("id", 2144)
                .body(bookingPojo)
                .when()
                .put("/booking/{id}");
        response.then().statusCode(200);
        response.then().time(lessThan(3000L));
        response.prettyPrint();
    }

}
