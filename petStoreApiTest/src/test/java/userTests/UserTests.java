package userTests;

import base.BaseTest;
import io.restassured.specification.RequestSpecification;
import utils.DataProviders;
import org.testng.annotations.Test;

import static endpoints.Endpoints.*;
import static utils.Assertions.*;

public class UserTests extends BaseTest {
    public RequestSpecification requestSpecification;

    @Test(dataProvider = "userProvider", dataProviderClass = DataProviders.class)
    public void postCreateUser(String val){
        requestSpecification = rb.createPostRequest(val);
        response = requestSpecification.post(BASE_URL + USER);
        //TODO assertions eklenecek
        assertStatusCode(response);
        validateResponseTime(response,5000);
        printResponse(response);
    }
    @Test(dataProvider = "userListProvider", dataProviderClass = DataProviders.class)
    public void postCreateUserFromList(String val){
        requestSpecification = rb.createPostRequest(val);
        response = requestSpecification.post(BASE_URL + USER + USER_CREATE_WITH_LIST);
        //TODO assertions eklenecek
        assertStatusCode(response);
        validateResponseTime(response,5000);
        printResponse(response);
    }
    @Test
    public void getUserByUserName(){
        requestSpecification = rb.createRequest();
        response = requestSpecification.get(BASE_URL + USER + "/xatakany");
        //TODO assertions eklenecek
        assertStatusCode(response);
        validateResponseTime(response,5000);
        printResponse(response);
    }
    @Test
    public void getUserLogin(){
        requestSpecification = rb.createRequest();
        response = requestSpecification.queryParam("username","xatakany").queryParam("password","atakan123")
                .get(BASE_URL + USER + USER_LOGIN);
        //queryParam("username", getUsername()).queryParam("password",getPassword())
        //TODO assertions eklenecek
        assertStatusCode(response);
        validateResponseTime(response,5000);
        printResponse(response);
    }
    @Test
    public void getUserLogout(){
        requestSpecification = rb.createRequest();
        response = requestSpecification.get(BASE_URL + USER + USER_LOGOUT);
        //TODO assertions eklenecek
        assertStatusCode(response);
        validateResponseTime(response,5000);
        printResponse(response);
    }

}
