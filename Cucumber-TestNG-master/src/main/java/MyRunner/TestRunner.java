package MyRunner;


import config.BaseRunnerConfig;
import cucumber.api.CucumberOptions;





@CucumberOptions(
        features = {"src/main/java/Features/login1.feature"},
        glue = {"stepDefinitions"},
        monochrome = true,
        plugin = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport1.json",
				"rerun:target/cucumber-reports/rerun.txt" })

public class TestRunner extends BaseRunnerConfig{


}