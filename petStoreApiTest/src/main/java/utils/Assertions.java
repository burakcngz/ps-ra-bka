package utils;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;

import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.contains;

public class Assertions {
    //TODO KALDIRILACAK SIMDILIK TEST AMACLI BIR FONKSIYON
    public static void printResponse(Response res){
        System.out.println("RESPONSE : "+res.body().asPrettyString());
    }
    // TODO ASSERTIONLAR AKLA GELDIKCE BU ALANA EKLENEBILIR

    public static ValidatableResponse assertStatusCode(Response res){
        return res.then().assertThat().statusCode(HttpStatus.SC_OK);
    }
    public static <T> ValidatableResponse assertValueOfKey(Response res, String key, T expectedValue){
        return res.then().assertThat().body(key,equalTo(expectedValue));
    }
    public static <T> ValidatableResponse assertMultipleValueOfKey(Response res, Map<String,T> pairs){

        for (Map.Entry<String, ?> entry : pairs.entrySet()) {
            res.then().assertThat().body(entry.getKey(), equalTo(entry.getValue()));
        }
        return res.then();
    }
    public static <T> ValidatableResponse assertContainsValueOfKey(Response res, String key, T expectedValue){
        return res.then().assertThat().body(key,contains(expectedValue));
    }
    public static <T> ValidatableResponse assertContainsMultipleValueOfKey(Response res, Map<String,T> pairs){

        for (Map.Entry<String, ?> entry : pairs.entrySet()) {
            res.then().assertThat().body(entry.getKey(), contains(entry.getValue()));
        }
        return res.then();
    }
    public static ValidatableResponse assertArraySize(Response res,int size){
        return res.then().body("size()",is(size));
    }
    public static ValidatableResponse assertNullValue(Response res, String key) {
        return res.then().assertThat().body(key, is(nullValue()));
    }
    public static ValidatableResponse assertNotNullValue(Response res, String key) {
        return res.then().assertThat().body(key, not(is(nullValue())));
    }
    public static ValidatableResponse validateResponseTime(Response res, long time){
        return res.then().time(Matchers.lessThan(time));
    }

}
