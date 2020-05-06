package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resource/Feature", glue = {
		"StepDefination" }, format = { "pretty", "html:target/cucumber" }, tags="Smoke")

public class DefaultRunner extends AbstractTestNGCucumberTests {
	
}

