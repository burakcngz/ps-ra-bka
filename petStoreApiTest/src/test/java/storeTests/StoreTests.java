package storeTests;

import base.BaseTest;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import utils.DataProviders;

import static endpoints.Endpoints.*;
import static utils.Assertions.*;


public class StoreTests extends BaseTest {
public RequestSpecification requestSpecification;
    @Test(dataProvider = "orderProvider",dataProviderClass = DataProviders.class)
    public void placeOrder(String val){
        requestSpecification = rb.createPostRequest(val);
        response = requestSpecification.post(BASE_URL+STORE_ORDER);
        assertStatusCode(response);
        assertNotNullValue(response,"id");
        assertValueOfKey(response,"status","placed");
        printResponse(response);
    }
    @Test
    public void getInventory(){
        response = requestSpecification.get(BASE_URL+STORE_INVENTORY);
        assertStatusCode(response);
        assertNotNullValue(response,"sold");
        printResponse(response);
    }
    @Test
    public void getOrderById(){
        response = requestSpecification.get(BASE_URL+STORE_ORDER+"8");
        assertStatusCode(response);
        assertNotNullValue(response,"id");
        assertValueOfKey(response,"status","placed");
        printResponse(response);
    }

    @Test
    public void deleteOrderById(){
        response = requestSpecification.delete(BASE_URL+STORE_ORDER+"8");
        assertStatusCode(response);
        assertNotNullValue(response,"type");
        assertValueOfKey(response,"message","8");
        printResponse(response);
    }
}
