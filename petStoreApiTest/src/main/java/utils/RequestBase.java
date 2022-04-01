package utils;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static endpoints.Endpoints.BASE_URL;

public class RequestBase {

    public static RequestSpecification requestSpecification;
    // Setup da yaratılan request e loglama ve https validation ve header üzerinden auth ekledikten sonra her istekte bu özellikler oluyor artık.
    public RequestSpecification createRequest(){
        RestAssured.baseURI = BASE_URL;
        requestSpecification = RestAssured
                .given()
                .log()
                .all()
                .relaxedHTTPSValidation()
                .header("api_key","special-key");
        return requestSpecification;
    }
    public RequestSpecification createPostRequest(String json){
        requestSpecification.body(json).header("Content-Type","application/json");
        return requestSpecification;
    }
    public RequestSpecification createPostRequestWithFormData(){
        requestSpecification.header("Content-Type","application/x-www-form-urlencoded");
        return requestSpecification;
    }
    //FILE Ekleneceği zaman bu kullanılacak.
    public RequestSpecification createPostRequestWithMultiPartFormData(){
        requestSpecification.header("Content-Type","multipart/form-data");
        return requestSpecification;
    }
    public RequestSpecification createPutRequest(String json){
        requestSpecification.body(json).header("Content-Type","application/json");
        return requestSpecification;
    }
    public RequestSpecification createDeleteRequest(){
        return requestSpecification.header("Content-Type","application/json");
    }
}
