package co.com.psl.automation.interview.ricardolarrahondo.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.components.HtmlTable;
import net.thucydides.core.webdriver.WebDriverFacade;

@DefaultUrl("http://automatizacion.herokuapp.com/rlarrahondo/appointmentScheduling")
public class AppointmentSchedulingPage extends PageObject {
	@FindBy(id = "datepicker")
	private WebElementFacade datePickerField;
	@FindBy(xpath = "//label[@for='patient-identification']/following-sibling::*")
	private WebElementFacade pacientDocumentField;
	@FindBy(xpath = "//label[@for='doctor-identification']/following-sibling::*")
	private WebElementFacade doctorDocumentField;
	@FindBy(xpath = "//label[@for='note']/following-sibling::*")
	private WebElementFacade noteField;

	/*
	 * @WhenPageOpens private void maximizeWindow() {
	 * getDriver().manage().window().maximize(); }
	 */

	public void enterDate(String date) {
		datePickerField.type(date);
		// If we are not in firefox, use actions to hide datePicker, do not
		// change the logic to set the date, Marrionette driver is so bugged.
		if (!(((WebDriverFacade) getDriver()).getDriverName().equalsIgnoreCase("firefox"))) {
			Actions action = new Actions(getDriver());
			action.moveToElement(noteField);
			action.click().build().perform();
		}
	}

	public void enterPacientDocument(String pacientDocument) {
		pacientDocumentField.type(pacientDocument);

	}

	public void enterDoctortDocument(String doctorDocument) {

		doctorDocumentField.type(doctorDocument);

	}

	public void submit() {
		find(By.xpath("//a[@onclick='submitForm()']")).click();

	}

	public void enterNoteInformation(String note) {
		noteField.type(note);
	}

	public List<String> getTableInformation() {
		List<String> content = new ArrayList<>();
		HtmlTable table = new HtmlTable(find(By.xpath("/html/body/div/div/div/div[3]/div/table")));
		for (WebElement row : table.getRowElementsFor(Arrays.asList("a", "b"))) {
			List<WebElement> columns = row.findElements(By.xpath("td"));
			content.add(columns.get(1).getText());
		}
		return content;
	}
}
