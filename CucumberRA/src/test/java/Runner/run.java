package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= "src/test/java/Features",glue="Steps",publish=true)
public class run extends AbstractTestNGCucumberTests {

}
