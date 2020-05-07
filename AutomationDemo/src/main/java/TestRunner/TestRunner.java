package TestRunner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import reports.ExtentReport;
import reports.HtmlWriter;
import util.BaseTest;

@RunWith(Cucumber.class)
@CucumberOptions
		( features= {"src/main/java/features"}, //the path of the feature files
		glue={"stepdefinitions"}, //the path of the step definition files
		//format= {"pretty","html:test-outout", "junit:junit_xml/cucumber.xml"}, //to generate different types of reporting	
		tags = {"@RegressionTest,@RegressionTest1"},
		plugin = {"pretty","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/extentreport.html","rerun:rerun/failed_scenarios.txt","html:target/reports"},
		monochrome = true, //display the console output in a proper readable format
		strict = false, //it will check if any step is not defined in step definition file
		dryRun = false //to check the mapping is proper between feature file and step def file
				//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports/report.html\",
		)

public class TestRunner extends BaseTest {
	
	@BeforeClass
	
	public static void setup()throws IOException
	{
		HtmlWriter.deletefile(".//target");
		HtmlWriter.deletefile(".//logs");
		HtmlWriter.deletefile(".//screenshots");
	}
	
	@AfterClass
	public static void stop()throws IOException
	{
		ExtentReport.writeExtentReport();
	}

}
