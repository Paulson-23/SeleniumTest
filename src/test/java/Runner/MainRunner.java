package Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(tags = "((@OrangeHRM_Login and (@Valid_Login or @Invalid_Login)) or (@OrangeHRM_Admin and @Admin_Search))",
        plugin = {"pretty", "html:target/cucumber/report.html",
                "json:target/cucumber/report.json",
                "junit:target/cucumber-results.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        features = "src/test/resources/Features",
        glue = {"StepDefinitions","Base"},
        dryRun = false,
        monochrome = true)

public class MainRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
