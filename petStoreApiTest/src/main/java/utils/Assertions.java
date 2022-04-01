package utils;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static org.hamcrest.CoreMatchers.*;

public class Assertions {
    //TODO KALDIRILACAK SIMDILIK TEST AMACLI BIR FONKSIYON
    public static void printResponse(Response res){
        System.out.println("RESPONSE : "+res.body().asPrettyString());
    }
// TODO ASSERTIONLAR AKLA GELDIKCE BU ALANA EKLENEBILIR
    public static ValidatableResponse assertStatusCode(Response res){
        return res.then().assertThat().statusCode(HttpStatus.SC_OK);
    }
    public static ValidatableResponse assertValueOfKey(Response res, String key, String expectedValue){
        return res.then().assertThat().body(key,equalTo(expectedValue));
    }
    public static ValidatableResponse assertNumericValueOfKey(Response res, String key, long expectedValue){
        return res.then().assertThat().body(key,is(expectedValue));
    }
    public static ValidatableResponse assertArraySize(Response res,int size){
        return res.then().body("size()",is(size));
    }
}
