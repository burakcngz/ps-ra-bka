package utils;

import models.PetModel;
import models.subModels.CategoryModel;
import models.subModels.TagModel;

public class ObjectCreator {
    //TODO BURALARA BIRSEYLER DUSUNMEMIZ GEREKECEK
    private static long petId = 9223372000001097001L;
    private static String petName = "Pet New Added";
    private static String[] photoUrls = {"BC","KY","AY"};
    private static String status = "Available";
    private static long categoryId = 1;
    private static String categoryName = "Dog";
    private static long tagId = 1;
    private static String tagName = "Tag No 1";

    public static PetModel createPet(){
        CategoryModel category = new CategoryModel(categoryId,categoryName);
        TagModel tag = new TagModel(tagId,tagName);
        PetModel pet = new PetModel(petId,category,petName,photoUrls,new TagModel[]{tag},status);
        return pet;
    }
    public static PetModel updatePet(){
        CategoryModel category = new CategoryModel(categoryId,categoryName);
        TagModel tag = new TagModel(tagId+1,tagName +" Updated");
        PetModel pet = new PetModel(petId,category,petName+" Updated",photoUrls,new TagModel[]{tag},status);
        return pet;
    }

}
