package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "Features",
monochrome = true,
glue = {"StepDefinition"},

        plugin = {"pretty", "html:target/cucumber-reports/TestReports.html"}) // Output format and location of the test report)
public class runner
{

}
