package co.com.psl.automation.interview.ricardolarrahondo.steps.serenity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;

import co.com.psl.automation.interview.ricardolarrahondo.pages.AppointmentSchedulingPage;
import co.com.psl.automation.interview.ricardolarrahondo.steps.Messages;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class EndUserSteps extends ScenarioSteps {

	/**
	 * 
	 */

	private SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	private static final long serialVersionUID = 7223580267927985198L;
	AppointmentSchedulingPage appointmentPage;

	public void is_the_home_page() {
		appointmentPage.open();
	}

	public void does_not_select_date() {
		appointmentPage.enterPacientDocument(Messages.getString("fakePacientDocument"));
		appointmentPage.enterDoctortDocument(Messages.getString("fakeDoctorDocument"));

	}

	public void submits_form() {
		appointmentPage.submit();

	}

	@Step
	public void should_see_missing_date_error_message(String errorMessage) {
		appointmentPage.waitForTextToAppear(errorMessage);
	}

	public void does_not_type_his_document() {
		appointmentPage.enterDate(formatter.format(new Date()));

		appointmentPage.enterDoctortDocument(Messages.getString("realDoctorDocument"));
	}

	public void does_not_type_his_doctor_document() {
		appointmentPage.enterDate(formatter.format(new Date()));

		appointmentPage.enterPacientDocument(Messages.getString("realPacientDocument"));
	}

	public void chooses_the_current_date_as_an_appoiment_date() {
		appointmentPage.enterDate(formatter.format(new Date()));
		appointmentPage.enterPacientDocument(Messages.getString("realPacientDocument"));
		appointmentPage.enterDoctortDocument(Messages.getString("realDoctorDocument"));
	}

	public void fills_form_but_his_document_is_not_registered_in_the_system() {

		appointmentPage.enterDate(formatter.format(getTomorrowDate()));
		appointmentPage.enterPacientDocument(Messages.getString("fakePacientDocument"));
		appointmentPage.enterDoctortDocument(Messages.getString("realDoctorDocument"));
	}

	public void fills_form_but_his_doctor_document_is_not_registered_in_the_system() {

		appointmentPage.enterDate(formatter.format(getTomorrowDate()));
		appointmentPage.enterPacientDocument(Messages.getString("realPacientDocument"));
		appointmentPage.enterDoctortDocument(Messages.getString("fakeDoctorDocument"));
	}

	public void fills_form_with_correct_information() {

		appointmentPage.enterDate(formatter.format(getTomorrowDate()));
		appointmentPage.enterPacientDocument(Messages.getString("realPacientDocument"));
		appointmentPage.enterDoctortDocument(Messages.getString("realDoctorDocument"));
		appointmentPage.enterNoteInformation(Messages.getString("noteRegistered"));
	}

	private Date getTomorrowDate() {
		DateTime dtOrg = new DateTime(new Date());
		DateTime dtPlusOne = dtOrg.plusDays(1);
		return dtPlusOne.toDate();

	}

	public void should_see_the_correct_information_of_the_appointment() {

		assertThat(appointmentPage.getTableInformation(),
				containsInAnyOrder(Messages.getString("realPacientDocument"), Messages.getString("realDoctorDocument"),
						Messages.getString("noteRegistered"), Messages.getString("doctorName"),
						Messages.getString("pacientName"), formatter.format(getTomorrowDate())));
	}
}