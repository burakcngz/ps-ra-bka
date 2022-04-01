package base;

import io.restassured.response.Response;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.RequestBase;

public class BaseTest {
    //Request base den bir obje oluşturup onu setup da ilk aşamada yaratıyoruz.
    public RequestBase rb = new RequestBase();
    public Response response;
    @BeforeSuite
    public void setUp(){
        rb.createRequest();
    }

    // TODO : Raporlama eklendiğinde bu alana konulacak.
    @AfterSuite
    public void tearDown(){
        System.out.println("Test Sonlandı");
    }
}
