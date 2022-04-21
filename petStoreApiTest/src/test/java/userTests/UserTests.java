package userTests;

import base.BaseTest;
import io.restassured.specification.RequestSpecification;
import utils.DataProviders;
import org.testng.annotations.Test;

import static endpoints.Endpoints.*;
import static utils.Assertions.*;

public class UserTests extends BaseTest {

    @Test(dataProvider = "userProvider", dataProviderClass = DataProviders.class)
    public void postCreateUser(String val){
        response = rb.createPostRequest(val)
                .post(BASE_URL + USER);
        //TODO assertions eklenecek
        assertStatusCode(response);
        validateResponseTime(response,5000);
        printResponse(response);
    }
    @Test(dataProvider = "userListProvider", dataProviderClass = DataProviders.class)
    public void postCreateUserFromList(String val){
        response = rb.createPostRequest(val)
                .post(BASE_URL + USER + USER_CREATE_WITH_LIST);
        //TODO assertions eklenecek
        assertStatusCode(response);
        validateResponseTime(response,5000);
        printResponse(response);
    }
    @Test
    public void getUserByUserName(){
        response = rb.createRequest()
                .get(BASE_URL + USER + "/xatakany");
        //TODO assertions eklenecek
        assertStatusCode(response);
        validateResponseTime(response,5000);
        printResponse(response);
    }
    @Test
    public void getUserLogin(){
        response = rb.createRequest()
                .queryParam("username","xatakany")
                .queryParam("password","atakan123")
                .get(BASE_URL + USER + USER_LOGIN);
        //TODO assertions eklenecek
        assertStatusCode(response);
        validateResponseTime(response,5000);
        printResponse(response);
    }
    @Test
    public void getUserLogout(){
        response = rb.createRequest()
                .get(BASE_URL + USER + USER_LOGOUT);
        //TODO assertions eklenecek
        assertStatusCode(response);
        validateResponseTime(response,5000);
        printResponse(response);
    }

}
