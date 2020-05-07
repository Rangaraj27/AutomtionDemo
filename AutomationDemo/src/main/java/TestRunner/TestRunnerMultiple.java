package TestRunner;


import org.junit.runner.RunWith;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
        jsonReport = "target/cucumber-reports/CucumberTestReport.json",
        retryCount = 3,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        coverageReport = true,
        jsonUsageReport = "target/cucumber-reports/cucumber-usage.json",
        usageReport = false,
        toPDF = true,
        excludeCoverageTags = {"@flaky" },
        includeCoverageTags = {"@passed" },
        outputFolder = "target/cucumber-reports/extended-report")

@CucumberOptions(
        features =  {"src/main/java/Features/"},
        glue=       {"stepDefinitions"},
        monochrome = true,
        tags =      {"@RegressionTest"},
        plugin =    {
        		
        		 	"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
                    "pretty", "html:target/cucumber-reports/cucumber-html-report",
                    "json:target/cucumber-reports/CucumberTestReport.json",
                    "rerun:target/rerun-reports/rerun.txt"}
        )

public class TestRunnerMultiple {

}
