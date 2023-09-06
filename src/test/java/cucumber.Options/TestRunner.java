package cucumber.Options;

import io.cucumber.junit.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features ="src/test/java/Features/placeValidation.feature",
        plugin = {"json:target/jsonReports/cucumber-report.json"},
        glue ={"StepDefinitions"},
        tags= "@deletePlace"
)
public class TestRunner {
}
