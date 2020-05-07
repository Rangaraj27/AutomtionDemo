package stepdefinitions;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;


import com.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageobjects.AdminPage;
import util.BaseTest;



public class AdminTest extends BaseTest {
	
	//private static final Logger LOGGER = LoggerFactory.getLogger(AdminTest.class);
	private static Logger LOGGER=Logger.getLogger(BaseTest.class.getName());
	
	
	@Given("^user enters <username> and <password>$")
	public void user_enters_username_and_password(DataTable table) throws Throwable {
		List<List<String>> data = table.raw();
		LOGGER.info("Getting datatable information");
		System.out.println(data.get(0).get(0));
		String username=data.get(0).get(0);
		String password=data.get(0).get(1);
		System.out.println(data.get(0).get(1));
		
		String result=login.loginadminpage(username,password);
		if(result.equals("Success"))
		{
			Reporter.addScenarioLog("Login is successfully verified");
			String path=captureScreenshot("loginverified");
			Reporter.addScreenCaptureFromPath(path);
		}
		else
		{
			Assert.fail();
			Reporter.addScenarioLog("Login is not successful");
			capturscreenshot("loginFailed");
			//Reporter.addScreenCaptureFromPath(BasePage.getproperty("snaplocation").toString());
		}
	    
	}
	

	private String loginadminpage(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}


	@Then("^verify the  user is on home page$")
	public void verify_the_user_is_on_home_page() throws Throwable {
		String result=login.verfyhomepage();
		if(result.equals("Success"))
		{
			Reporter.addScenarioLog("Login is successfully verified");
			captureScreenshot("CredentialsVerified");
		}
		else
		{
			Assert.fail();
			Reporter.addScenarioLog("Header is not displayed Successfully");
			capturscreenshot("loginfailed");
			//Reporter.addScreenCaptureFromPath(BasePage.getproperty("snaplocation").toString());
		}
	}

	@Then("^search the Dashboard<dashboard> with product <product> and <value>$")
	public void search_the_product_product(DataTable table) throws Throwable {
		List<List<String>> data = table.raw();
		String dashboard=data.get(0).get(0);
		String productname=data.get(0).get(1);
		String value=data.get(0).get(2);
		//product=login.checkproductdashboard();
		String result=login.searchproduct(dashboard,productname,value);
		if(result.equals("Success"))
		{
			Reporter.addScenarioLog("Product is successfully verified");
			captureScreenshot("ProductDisplayedSuccessful");
		}
		else
		{
			Assert.fail();
			Reporter.addScenarioLog("Product is not verified successfully");
			captureScreenshot("ProductisnotDisplayedSuccessful");
			//Reporter.addScreenCaptureFromPath(BasePage.getproperty("snaplocation").toString());
		}
	   
	}
	

	@Then("^veriy product is dispalyed$")
	public void veriy_product_is_dispalyed(DataTable table) throws Throwable {
		//product=login.checkproductdashboard();
		List<List<String>> data = table.raw();
		String product=data.get(0).get(0);
		String result=login.veridyproductvalue(product);
		if(result.equals("Success"))
		{
			Reporter.addScenarioLog("Product is successfully verified");
			//Reporter.addScreenCaptureFromPath(".//screenshots//".toString());
		}
		else
		{
			Assert.fail();
			Reporter.addScenarioLog("Product is not verified successfully");
			capturscreenshot("productisnotmatched");
			//Reporter.addScreenCaptureFromPath(".//screenshots//".toString());
		}
	}



}
