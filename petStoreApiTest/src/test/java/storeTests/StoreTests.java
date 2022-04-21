package storeTests;

import base.BaseTest;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import utils.DataProviders;

import static endpoints.Endpoints.*;
import static utils.Assertions.*;


public class StoreTests extends BaseTest {
    @Test(dataProvider = "orderProvider",dataProviderClass = DataProviders.class)
    public void placeOrder(String val){
        response = rb.createPostRequest(val)
                .post(BASE_URL+STORE_ORDER);
        assertStatusCode(response);
        assertNotNullValue(response,"id");
        assertValueOfKey(response,"status","placed");
        validateResponseTime(response,5000);
        printResponse(response);
    }
    @Test
    public void getInventory(){
        response = rb.createRequest()
                .get(BASE_URL+STORE_INVENTORY);
        assertStatusCode(response);
        assertNotNullValue(response,"sold");
        validateResponseTime(response,5000);
        printResponse(response);
    }
    @Test
    public void getOrderById(){
        response = rb.createRequest()
                .get(BASE_URL+STORE_ORDER+"8");
        assertStatusCode(response);
        assertNotNullValue(response,"id");
        assertValueOfKey(response,"status","placed");
        validateResponseTime(response,5000);
        printResponse(response);
    }

    @Test
    public void deleteOrderById(){
        response = rb.createDeleteRequest()
                .delete(BASE_URL+STORE_ORDER+"8");
        assertStatusCode(response);
        assertNotNullValue(response,"type");
        assertValueOfKey(response,"message","8");
        validateResponseTime(response,5000);
        printResponse(response);
    }
}
