package runner;

import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", features = "src/java/pl/mroz/tau/mmopet/bdd/features/")
public class RunCucumberTest
{
}