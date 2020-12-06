package stepDef;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features = {"src/test/resources/Cucumber/cucumberPractice.feature"},
		glue = {"stepDef"},
		plugin = {"pretty",
				"json:target/cucumber-reports/cucumber.json",
		"html:target/cucumber-reports/cucumber.html"},

		monochrome = true



		)
public class CucumberRunner extends AbstractTestNGCucumberTests {



}
