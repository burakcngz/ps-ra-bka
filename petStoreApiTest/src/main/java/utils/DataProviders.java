package utils;

import com.google.gson.Gson;
import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name="petProvider")
    public static Object[][] petDataProvide(){
        Gson gson = new Gson();
        String petPayload = gson.toJson(ObjectCreator.createPet());
        return new Object[][]{
                {petPayload}
        };
    }
    @DataProvider(name="petPutProvider")
    public static Object[][] petPutDataProvide(){
        Gson gson = new Gson();
        String petPayload = gson.toJson(ObjectCreator.updatePet());
        return new Object[][]{
                {petPayload}
        };
    }
    @DataProvider(name="orderProvider")
    public static Object[][] orderDataProvide(){
        Gson gson = new Gson();
        String orderPayload = gson.toJson(ObjectCreator.createOrder());
        return new Object[][]{
                {orderPayload}
        };
    }
    @DataProvider(name="userProvider")
    public static Object[][] userDataProvide(){
        Gson gson = new Gson();
        String userPayload = gson.toJson(ObjectCreator.createUser());
        return new Object[][]{
                {userPayload}
        };
    }
    @DataProvider(name="userListProvider")
    public static Object[][] userListDataProvide(){
        Gson gson = new Gson();
        String userListPayload = gson.toJson(ObjectCreator.createUserFromList());
        return new Object[][]{
                {userListPayload}
        };
    }
}
