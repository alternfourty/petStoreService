package io.swagger.petstore.questions.pet;

import io.swagger.petstore.models.pet.Category;
import io.swagger.petstore.models.pet.PostPetModel;
import io.swagger.petstore.models.pet.Tag;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.List;

public class petBuilder implements Question<PostPetModel> {
    private final String id;
    private final String petName;
    private final String categoryName;

    public petBuilder(String id, String petName, String categoryName) {
        this.id = id;
        this.petName = petName;
        this.categoryName = categoryName;
    }

    @Override
    public PostPetModel answeredBy(Actor actor) {
        List<Tag> tagsList=new ArrayList<>();
        Category category = Category.builder()
                .name(categoryName)
                .id(0)
                .build();
        Tag tag = Tag.builder()
                .id(1)
                .name("")
                .build();

        tagsList.add(tag);
        PostPetModel petInfo;
        petInfo = PostPetModel.builder()
                .id(Long.parseLong(id))
                .name(petName)
                .category(category)
                .tags(tagsList)
                .build();
        return petInfo;
    }

    public static petBuilder was(String id, String petName, String categoryName){
        return new petBuilder(id, petName, categoryName);
    }
}
