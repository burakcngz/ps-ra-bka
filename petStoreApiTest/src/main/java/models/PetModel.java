package models;

import models.subModels.CategoryModel;
import models.subModels.TagModel;

public class PetModel {

    public long id;
    public CategoryModel category;
    public String name;
    public String[] photoUrls;
    public TagModel[] tags;
    public String status;

    public PetModel(long id, CategoryModel category, String name, String[] photoUrls, TagModel[] tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

}
