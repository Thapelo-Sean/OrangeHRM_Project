package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "Features",
monochrome = true,
glue = {"StepDefinition"})
public class runner extends AbstractTestNGCucumberTests
{

}
