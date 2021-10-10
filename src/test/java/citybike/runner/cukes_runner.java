package citybike.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {  "json:target/cucumber.json",
                "html:target/default-html-reports" //this line for basic Cucumber report
        },
        features = "src/test/resources/features/",
        glue = "citybike/step_definitions",
        dryRun = false,
        tags = "@wip"
)
public class cukes_runner {
}
