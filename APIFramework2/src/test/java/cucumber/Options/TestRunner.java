package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",plugin ="json:target/jsonReports/cucumber-report.json",glue= {"stepDefinations"},strict = true)
public class TestRunner {
//tags= {"@DeletePlace"}  // Add the tags to @CucumberOptions parameters to run specific tags as wanted
}
