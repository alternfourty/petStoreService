package io.swagger.petstore.tasks.pet;

import io.restassured.http.ContentType;
import io.swagger.petstore.models.pet.PostPetModel;
import io.swagger.petstore.questions.pet.petBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostPetTask implements Task {
    private final String endPoint;
    private final String id;
    private final String petName;
    private final String categoryName;



    public PostPetTask(String endPoint, String id, String petName, String categoryName) {
        this.petName = petName;
        this.endPoint = endPoint;
        this.id = id;
        this.categoryName = categoryName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        PostPetModel petData = actor.asksFor(petBuilder.was(id,petName,categoryName));

        actor.attemptsTo(
                Post.to(endPoint).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(petData)
                )
        );
    }

    public static PostPetTask addPet(String endPoint, String id, String petName, String categoryName){
        return instrumented(PostPetTask.class,endPoint,id,petName,categoryName);
    }
}

