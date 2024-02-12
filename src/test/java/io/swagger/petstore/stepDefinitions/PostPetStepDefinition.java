package io.swagger.petstore.stepDefinitions;

import io.cucumber.java.en.*;
import io.swagger.petstore.tasks.pet.PostPetTask;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static io.swagger.petstore.constants.Constants.URL_BASE_PET;

public class PostPetStepDefinition {

    private static final String restAPI = URL_BASE_PET;

    @When("user send a post request to the {string} and sent the pet {string}, pet name {string} and pet Category {string}")
    public void PetPost(String endpoint, String id, String petName, String categoryName) {
        Actor user = Actor.named("user")
                .whoCan(CallAnApi.at(restAPI));
        user.attemptsTo(
                PostPetTask.addPet(endpoint,id,petName,categoryName)
        );
    }
    @Then("user will receive a response code {int}")
    public void userWillReceiveAResponseCode(Integer code) {

    }

}
