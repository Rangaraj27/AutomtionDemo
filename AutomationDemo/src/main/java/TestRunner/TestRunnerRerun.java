package TestRunner;




import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import reports.ExtentReport;



@RunWith(Cucumber.class)
@CucumberOptions
		(  
		features= {"@rerun/failed_scenarios.txt"},  //the path of the rerun feature files
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports1/report.html"},// extent report plugin
		glue={"stepDefinitions"}, //the path of the step definition files
		//format= {"pretty","html:test-outout", "junit:junit_xml/cucumber.xml"}, //to generate different types of reporting	
		tags = {"@RegressionTest,~@SmokeTest"},
		monochrome = true, //display the console output in a proper readable format
		strict = true, //it will check if any step is not defined in step definition file
		dryRun = false //to check the mapping is proper between feature file and step def file
				
		)

public class TestRunnerRerun {
	
	@BeforeClass
	
	public static void setup()throws IOException
	{
		
	}
	
	@AfterClass
	public static void stop()throws IOException
	{
		ExtentReport.writeExtentReport();
	}

}


