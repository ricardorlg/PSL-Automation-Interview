package co.com.psl.automation.interview.ricardolarrahondo.steps;

import co.com.psl.automation.interview.ricardolarrahondo.steps.serenity.EndUserSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AppointmentSchedulingDefinitionSteps {

	@Steps
	EndUserSteps ricardo;

	@Given("the user is in the Schedule Appoinment page")
	public void givenTheUserIsOnTheWikionaryHomePage() {
		ricardo.is_the_home_page();
	}

	@When("^the user does not chooses a date$")
	public void does_not_chooses_a_date() throws Throwable {
		ricardo.does_not_select_date();
	}

	@When("^submits the form$")
	public void the_user_submit_the_form() throws Throwable {
		ricardo.submits_form();
	}

	@Then("^the system should show the \"([^\"]*)\"$")
	public void the_system_should_inform_about_the_missing_field(String field) throws Throwable {
		ricardo.should_see_missing_date_error_message(Messages.getString(field));
	}

	@When("^the user does not types his document$")
	public void the_user_does_not_types_his_document() throws Throwable {
		ricardo.does_not_type_his_document();
	}

	@When("^the user does not types his doctor document$")
	public void the_user_does_not_types_his_doctor_document() throws Throwable {
		ricardo.does_not_type_his_doctor_document();
	}

	@When("^the user chooses the current date as an appoiment date$")
	public void the_user_chooses_the_current_date_as_an_appoiment_date() throws Throwable {
		ricardo.chooses_the_current_date_as_an_appoiment_date();
	}

	@When("^the user fills the form but his document is not registered in the system$")
	public void the_user_fills_the_form_but_his_document_is_not_registered_in_the_system() throws Throwable {
		ricardo.fills_form_but_his_document_is_not_registered_in_the_system();
	}

	@When("^the user fills the form but the doctor document is not registered in the system$")
	public void the_user_fills_the_form_but_the_doctor_document_is_not_registered_in_the_system() throws Throwable {
		ricardo.fills_form_but_his_doctor_document_is_not_registered_in_the_system();
	}

	@When("^the user fills the form with correct information$")
	public void the_user_fills_the_form_with_correct_information() throws Throwable {
		ricardo.fills_form_with_correct_information();
	}

	@Then("^the correct information about the appointment$")
	public void the_correct_information_about_the_appointment() throws Throwable {
		ricardo.should_see_the_correct_information_of_the_appointment();
	}
}
