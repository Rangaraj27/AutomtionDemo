package stepdefinitions;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import util.BaseTest;

public class Hooks extends BaseTest {
	
	
	
	@Before ("@RegressionTest,@RegressionTest1")
	
	public void setupscenarios()
	{
		login=startScenario();
	}
	
	@After ("@RegressionTest,@RegressionTest1")
	
	public void stopscenarios()
	{
		
		stopExecution();
	
	}
	

}
