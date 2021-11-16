package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = ".//Features", glue = "stepDefinitions", dryRun = false, monochrome = true,

		plugin = { "pretty", "json:target/MyReports/report.json", "junit:target/MyReports/report.xml",
				"html:target/MyReports/report.html",

		}, publish = true

)
public class TestRunner {

}
