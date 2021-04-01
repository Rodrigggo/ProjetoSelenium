package Runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "resources\\features\\", glue = {"StepsDefinition"}, tags = {"~@ignore"},
dryRun = false , 
plugin = {
		"pretty",
		"html:target/cucumber-htmlreport",
		"json:target/cucumber-report.json",
		"com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport.html"},
monochrome = true)
public class RunFeature {


 @AfterClass
 public static void fim() {
	 
	 System.out.println("Fim dos testes");

 }

}
