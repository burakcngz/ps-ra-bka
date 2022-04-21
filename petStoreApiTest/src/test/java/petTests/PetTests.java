package petTests;

import base.BaseTest;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import utils.DataProviders;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static endpoints.Endpoints.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static utils.Assertions.*;


public class PetTests extends BaseTest {
    //region FIND PET BY ID
    @Test()
    public void getPetById(){
        response = rb.createRequest()
                .get(BASE_URL+GET_PET+"9223372000001097001");
        assertValueOfKey(response,"id",9223372000001097001L);
        validateResponseTime(response,5000);
        printResponse(response);

    }
    //endregion

    //region UPDATES A PET IN THE STORE WITH FORM DATA
    //TODO JSON SCHEMA VALIDATOR EKLENECEK
    @Test
    public void updatePetWithFormData(){
        response = rb.createPostRequestWithFormData()
                .param("name","Partial Updated")
                .param("status","available")
                .post(BASE_URL+UPDATE_PET+"9223372000001097001");
        assertStatusCode(response);
        validateResponseTime(response,5000);
        printResponse(response);
    }
    //endregion

    //region DELETES A PET
    //TODO JSON SCHEMA VALIDATOR EKLENECEK
    @Test
    public void deletePet(){

        response = rb.createDeleteRequest()
                .delete(BASE_URL+DELETE_PET+"9223372000001097001");
        assertStatusCode(response);
        validateResponseTime(response,5000);
        printResponse(response);
    }
    //endregion

    //region UPLOADS AN IMAGE FOR A PET
    //TODO JSON SCHEMA VALIDATOR EKLENECEK
    @Test
    public void uploadPetImage(){
        response = rb.createPostRequestWithMultiPartFormData()
                .multiPart("additionalMetadata","Meta Data Test Value")
                .multiPart("file",new File("atImage.jpg"))
                .post(BASE_URL+GET_PET+"9223372000001097001"+PET_UPLOAD_IMAGE);
        assertStatusCode(response);
        validateResponseTime(response,5000);
        printResponse(response);
    }
    //endregion

    //region ADD A NEW PET TO THE STORE
    @Test(dataProvider = "petProvider",dataProviderClass = DataProviders.class)
    public void addNewPet(String val){
        response = rb.createPostRequest(val)
                .post(BASE_URL+PET);
        assertValueOfKey(response,"name","Pet New Added");
        validateResponseTime(response,5000);
        printResponse(response);
    }
    //endregion

    //region UPDATE AN EXISTING PET
    @Test(dataProvider = "petPutProvider",dataProviderClass = DataProviders.class)
    public void updatePet(String val){
        response = rb.createPutRequest(val)
                .put(BASE_URL+PET);
        Map<String,Object> map;
        map = new HashMap<>();
        map.put("id",9223372000001097001L);
        map.put("name","Pet New Added Updated");
        map.put("category.name","Dog");
        map.put("tags[0].name","Tag No 1 Updated");
        assertMultipleValueOfKey(response,map);
        validateResponseTime(response,5000);
        printResponse(response);
    }
    //endregion

    //region FIND PETS BY STATUS
    @Test
    public void findPetByStatus(){
        response = rb.createRequest()
                .queryParam("status","available")
                .get(BASE_URL+PET_FIND_BY_STATUS);
        assertStatusCode(response);
        validateResponseTime(response,5000);
        printResponse(response);
    }
    //endregion
}
