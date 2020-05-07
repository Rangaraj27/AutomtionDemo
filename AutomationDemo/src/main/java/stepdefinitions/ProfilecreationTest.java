package stepdefinitions;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import util.BaseTest;
import util.ExcelUtility;

public class ProfilecreationTest extends BaseTest {

	private static Logger LOGGER = Logger.getLogger(ProfilecreationTest.class.getName());

	@Given("application is launched")
	public void application_is_launched() {

		LOGGER.info("Getting application launched");
		login1=login.checkonpage();
		String result = login1.launchapp();
		if (result.equals("Success")) {
			
			  Reporter.addScenarioLog("Application is launched");
			  getscreenshot("Profilecreated ");

			LOGGER.info("Application is launched");
		} else {
			Assert.fail();
			Reporter.addScenarioLog("Application is not launched successful");
			capturscreenshot("loginfail");
			// Reporter.addScreenCaptureFromPath(BasePage.getproperty("snaplocation").toString());
		}
	}

	@Then("^create profile using testdata \"([^\"]*)\"$")
	public void enter_the_details_to_create_login(String rowid) throws Exception {
		LOGGER.info("Register the profile");
		int rowindex = getrowIndex(System.getProperty("user.dir") + "//src//main//resources//testdata//", "testdata",
				"profile", rowid);
		testdata = getrowdata(System.getProperty("user.dir") + "//src//main//resources//testdata//", "testdata",
				"profile", rowindex);
		login1=login.checkonpage();
		String result = login1.createprofile(testdata, rowindex);
		if (result.equals("Success")) {
			Reporter.addScenarioLog("Login is successfully verified");
			LOGGER.info("Userprofile is created successfully");
			getscreenshot("Profile  created ");

		} else {
			Assert.fail();
			Reporter.addScenarioLog("Application is not launcched successful");
			getscreenshot("Profile not created ");
			}
	}

	@Then("^verify login \"([^\"]*)\"$")
	public void verify_the_login_credentials(String rowid) throws Exception {
		LOGGER.info("Register the profile");
		int rowindex = getrowIndex(System.getProperty("user.dir") + "//src//main//resources//testdata//", "testdata",
				"profile", rowid);
		testdata = getrowdata(System.getProperty("user.dir") + "//src//main//resources//testdata//", "testdata",
				"profile", rowindex);
		login1=login.checkonpage();
		String result = login1.logintoprofile(testdata);
		if (result.equals("Success")) {
			Reporter.addScenarioLog("Login is successfully verified");
			LOGGER.info("Login is verfied successfully");

		} else {
			Assert.fail();
			Reporter.addScenarioLog("Application is not launcched successful");
			getscreenshot("Profile not validated");
		}

	}
}
