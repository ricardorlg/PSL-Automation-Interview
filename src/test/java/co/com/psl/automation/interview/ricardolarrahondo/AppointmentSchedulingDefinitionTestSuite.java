package co.com.psl.automation.interview.ricardolarrahondo;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/appointment_scheduling")
public class AppointmentSchedulingDefinitionTestSuite {
}
