package utils;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

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
    public static ValidatableResponse assertMultipleValueOfKey(Response res, Map<String,String> pairs){

        for (Map.Entry<String, String> entry : pairs.entrySet()) {
            res.then().assertThat().body(entry.getKey(), equalTo(entry.getValue()));
        }
        return res.then();
    }
/*
    public static ValidatableResponse assertValueOfKey(Response res, String key1, String expectedValue1,
                                                       String key2, String expectedValue2){
        return res.then().assertThat().body(key1,equalTo(expectedValue1),
                key2,equalTo(expectedValue2));
    }
    public static ValidatableResponse assertValueOfKey(Response res, String key1, String expectedValue1,
                                                       String key2, String expectedValue2,
                                                       String key3, String expectedValue3){
        return res.then().assertThat().body(key1,equalTo(expectedValue1),
                key2,equalTo(expectedValue2),
                key3,equalTo(expectedValue3));
    }
    */


    public static ValidatableResponse assertNumericValueOfKey(Response res, String key, long expectedValue){
        return res.then().assertThat().body(key,is(expectedValue));
    }
    public static ValidatableResponse assertArraySize(Response res,int size){
        return res.then().body("size()",is(size));
    }
    public static ValidatableResponse assertContainsValueOfKey(Response res, String key, String expectedValue){
        return res.then().assertThat().body(key,containsString(expectedValue));
    }
    public static ValidatableResponse assertContainsValueOfKey(Response res, String key1, String expectedValue1,
                                                               String key2, String expectedValue2){
        return res.then().assertThat().body(key1,containsString(expectedValue1),
                key2,containsString(expectedValue2));
    }
    public static ValidatableResponse assertContainsValueOfKey(Response res, String key1, String expectedValue1,
                                                               String key2, String expectedValue2,
                                                               String key3, String expectedValue3){
        return res.then().assertThat().body(key1,containsString(expectedValue1),
                key2,containsString(expectedValue2),
                key3,containsString(expectedValue3));
    }
    public static ValidatableResponse assertNullValue(Response res, String key) {
        return res.then().assertThat().body(key, is(nullValue()));
    }
    public static ValidatableResponse assertNotNullValue(Response res, String key) {
        return res.then().assertThat().body(key, not(is(nullValue())));
    }

}
