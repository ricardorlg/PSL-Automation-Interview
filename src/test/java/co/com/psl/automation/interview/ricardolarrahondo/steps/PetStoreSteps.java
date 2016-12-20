package co.com.psl.automation.interview.ricardolarrahondo.steps;

import static net.serenitybdd.rest.SerenityRest.rest;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import com.google.common.collect.Lists;

import co.com.psl.automation.interview.ricardolarrahondo.model.Pet;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PetStoreSteps {
	List<Pet> pets;

	@Given("I have the following pets?")
	public void i_have_the_following_pets(List<Pet> pets) {
		this.pets = Lists.newArrayList(pets);
	}

	@When("I add the pet to the store")
	public void i_add_the_pet_to_the_store() {
		for (Pet pet : pets) {
			String jsonPet = "{\"id\": " + pet.getId() + " , \"name\": \"" + pet.getName()
					+ "\", \"photoUrls\": [], \"status\": \"" + pet.getStatus() + "\"}";

			rest().given().contentType("application/json").content(jsonPet).log().all()
					.post("http://petstore.swagger.io/v2/pet");

		}
	}

	@Then("the pets? should be available in the store")
	public void pets_should_be_available() {
		for (Pet pet : pets) {
			rest().log().all().get("http://petstore.swagger.io/v2/pet/{id}", pet.getId()).then().statusCode(200).and()
					.body("name", equalTo(pet.getName()));
		}
	}

	@When("I delete the pet from the store")
	public void i_delete_the_pet_from_the_store() {

		rest().given().contentType("application/json").log().all()
				.delete("http://petstore.swagger.io/v2/pet/{id}", pets.get(0).getId()).then().assertThat()
				.statusCode(200);

	}

	@Then("the pets? should not be available in the store")
	public void pets_should_not_be_available() {

		rest().log().all().get("http://petstore.swagger.io/v2/pet/{id}", pets.get(0).getId()).then().assertThat()
				.statusCode(404);

	}

}
