package OrangeHRM;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "Features",
monochrome = true,
glue = {""})
public class runner
{

}
