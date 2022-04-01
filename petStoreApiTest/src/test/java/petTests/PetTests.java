package petTests;

import base.BaseTest;
import org.testng.annotations.Test;
import utils.DataProviders;

import java.io.File;

import static endpoints.Endpoints.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static utils.Assertions.*;
import static utils.RequestBase.requestSpecification;


public class PetTests extends BaseTest {

    //region FIND PET BY ID
    @Test
    public void getPetById(){
        response = requestSpecification.get(BASE_URL+GET_PET+"9223372000001097001");
        assertNumericValueOfKey(response,"id",9223372000001097001L);
        printResponse(response);

    }
    //endregion

    //region UPDATES A PET IN THE STORE WITH FORM DATA
    //TODO JSON SCHEMA VALIDATOR EKLENECEK
    @Test
    public void updatePetWithFormData(){
        requestSpecification = rb.createPostRequestWithFormData();
        response = requestSpecification.param("name","Partial Updated").param("status","available").post(BASE_URL+UPDATE_PET+"9223372000001097001");
        assertStatusCode(response);
        printResponse(response);
    }
    //endregion

    //region DELETES A PET
    //TODO JSON SCHEMA VALIDATOR EKLENECEK
    @Test
    public void deletePet(){
        requestSpecification = rb.createDeleteRequest();
        response = requestSpecification.delete(BASE_URL+DELETE_PET+"9223372000001097001");
        assertStatusCode(response);
        printResponse(response);
    }
    //endregion

    //region UPLOADS AN IMAGE FOR A PET
   //TODO JSON SCHEMA VALIDATOR EKLENECEK
    @Test
    public void uploadPetImage(){
        requestSpecification = rb.createPostRequestWithMultiPartFormData();
        response = requestSpecification.multiPart("additionalMetadata","Meta Data Test Value").multiPart("file",new File("atImage.jpg")).post(BASE_URL+GET_PET+"9223372000001097001"+PET_UPLOAD_IMAGE);
        assertStatusCode(response);
        printResponse(response);
    }
    //endregion

    //region ADD A NEW PET TO THE STORE
    @Test(dataProvider = "petProvider",dataProviderClass = DataProviders.class)
    public void addNewPet(String val){
        requestSpecification = rb.createPostRequest(val);
        response = requestSpecification.post(BASE_URL+PET);
        assertValueOfKey(response,"name","Pet New Added");
        printResponse(response);
    }
    //endregion

    //region UPDATE AN EXISTING PET
    @Test(dataProvider = "petPutProvider",dataProviderClass = DataProviders.class)
    public void updatePet(String val){
        requestSpecification = rb.createPutRequest(val);
        response = requestSpecification.put(BASE_URL+PET);
        assertValueOfKey(response,"name","Pet New Added Updated");
        printResponse(response);
    }
    //endregion

    //region FIND PETS BY STATUS
    @Test
    public void findPetByStatus(){
        response = requestSpecification.queryParam("status","available").get(BASE_URL+PET_FIND_BY_STATUS);
        assertStatusCode(response);
        printResponse(response);
    }
    //endregion
}
