package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/resources/FeatureFIle/sauceDemo.feature",
        dryRun = false,
        glue = "stepDef",
        publish = true,
        monochrome = true,
        //tags = "MaximumValueSelectionScenario",
        plugin = {"pretty","html:Html_Output/output.html","junit:Xml_Output/output.xml","json:Json_Output/output.json"})

public class TestRunner {
}
