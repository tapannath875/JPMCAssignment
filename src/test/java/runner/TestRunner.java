package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features/news.feature",
        glue = {"org.example.stepdefs", "hooks"},
        plugin = {"pretty", "html:target/cucumber-reports/report.html", "json:target/cucumber.json"},
        monochrome = true,
        publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios(){
    return super.scenarios();
    }
}
