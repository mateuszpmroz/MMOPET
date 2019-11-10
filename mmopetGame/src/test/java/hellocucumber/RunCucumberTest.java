package hellocucumber;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(plugin = "pretty", features = "src/java/pl/mroz/tau/mmopet/bdd/features/")
public class RunCucumberTest
{
}