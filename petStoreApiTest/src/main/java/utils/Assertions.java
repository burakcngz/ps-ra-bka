package utils;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;

import java.util.Map;

import static org.hamcrest.CoreMatchers.*;

public class Assertions {
    //TODO KALDIRILACAK SIMDILIK TEST AMACLI BIR FONKSIYON
    public static void printResponse(Response res){
        System.out.println("RESPONSE : "+res.body().asPrettyString());
    }
    // TODO ASSERTIONLAR AKLA GELDIKCE BU ALANA EKLENEBILIR

    //TODO Assertionlar için sadece string gibi düşünülmüş ama bunları generic type olarak kullanmak gerek hep string dönmeyebiliyor.
    public static ValidatableResponse assertStatusCode(Response res){
        return res.then().assertThat().statusCode(HttpStatus.SC_OK);
    }
    public static ValidatableResponse assertValueOfKey(Response res, String key, String expectedValue){
        return res.then().assertThat().body(key,equalTo(expectedValue));
    }
    public static ValidatableResponse assertMultipleValueOfKey(Response res, Map<String,?> pairs){

        for (Map.Entry<String, ?> entry : pairs.entrySet()) {
            res.then().assertThat().body(entry.getKey(), equalTo(entry.getValue()));
        }
        return res.then();
    }
    public static ValidatableResponse assertNumericValueOfKey(Response res, String key, long expectedValue){
        return res.then().assertThat().body(key,is(expectedValue));
    }
    public static ValidatableResponse assertMultipleNumericValueOfKey(Response res, Map<String,Integer> pairs){

        for (Map.Entry<String, Integer> entry : pairs.entrySet()) {
            res.then().assertThat().body(entry.getKey(), is(entry.getValue()));
        }
        return res.then();
    }
    public static ValidatableResponse assertContainsValueOfKey(Response res, String key, String expectedValue){
        return res.then().assertThat().body(key,containsString(expectedValue));
    }
    public static ValidatableResponse assertContainsMultipleValueOfKey(Response res, Map<String,String> pairs){

        for (Map.Entry<String, String> entry : pairs.entrySet()) {
            res.then().assertThat().body(entry.getKey(), containsString(entry.getValue()));
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
