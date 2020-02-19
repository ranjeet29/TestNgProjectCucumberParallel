package MyRunner;

import config.BaseRunnerConfig;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;




@CucumberOptions(
        features = "src/main/java/Features/login2.feature",
        glue = {"stepDefinitions"},
        monochrome = true,
        plugin = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport2.json",
				"rerun:target/cucumber-reports/rerun.txt" })

public class TestRunner2 extends BaseRunnerConfig{

	
}