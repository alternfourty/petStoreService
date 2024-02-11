package io.swagger.petstore.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/PostPet.feature"},
        glue = "io.swagger.petstore.stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class Runner {
}
