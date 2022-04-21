package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

import static endpoints.Endpoints.BASE_URL;

public class RequestBase {

    public RequestSpecification requestSpecification;

    public RequestSpecification reqSpecBuilder(){
        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setBaseUri(BASE_URL);
        reqBuilder.setRelaxedHTTPSValidation();
        reqBuilder.log(LogDetail.ALL);
        reqBuilder.addHeader("api_key","special-key");
        requestSpecification = reqBuilder.build();
        return requestSpecification;
    }
    // Setup da yaratılan request e loglama ve https validation ve header üzerinden auth ekledikten sonra her istekte bu özellikler oluyor artık.
    public RequestSpecification createRequest(){
        return RestAssured.given(reqSpecBuilder());
    }
    public RequestSpecification createPostRequest(String json){
        return RestAssured.given(reqSpecBuilder().body(json).header("Content-Type","application/json"));
    }
    public RequestSpecification createPostRequestWithFormData(){
        return RestAssured.given(reqSpecBuilder().header("Content-Type","application/x-www-form-urlencoded"));
    }
    //FILE Ekleneceği zaman bu kullanılacak.
    public RequestSpecification createPostRequestWithMultiPartFormData(){
        return RestAssured.given(reqSpecBuilder().header("Content-Type","multipart/form-data"));
    }
    public RequestSpecification createPutRequest(String json){
        return RestAssured.given(reqSpecBuilder().body(json).header("Content-Type","application/json"));
    }
    public RequestSpecification createDeleteRequest(){
        return RestAssured.given(reqSpecBuilder().header("Content-Type","application/json"));
    }
}
