package pageobjects;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import util.BaseTest;

public class LoginPage extends BaseTest {

	private static Logger LOGGER = Logger.getLogger(LoginPage.class.getName());

	@FindBy(xpath = "//li[@id='Primary_Navbar-Home']")
	private static WebElement homepage;

	@FindBy(xpath = "//li[@menuitemname='Account']/a")
	private static WebElement account;

	@FindBy(xpath = "//li[@menuitemname='Account']/ul/li")
	private static List<WebElement> accountoption;

	@FindBy(xpath = "//input[@id='inputFirstName']")
	private static WebElement firstname;

	@FindBy(xpath = "//input[@id='inputLastName']")
	private static WebElement lastname;

	@FindBy(xpath = "//input[@id='inputEmail']")
	private static WebElement email;

	@FindBy(xpath = "//input[@id='inputPhone']")
	private static WebElement phonenumber;

	private String countrytxt = "(//ul[@class='country-list dropup']/li/span[contains(text(),'%s')])[2]";
	
	@FindBy(xpath="//ul[@class='country-list dropup']/li/span")
	private static List<WebElement> countryoptions;

	@FindBy(xpath = "//div[@class='flag-container']")
	private static WebElement countryflag;
	
	@FindBy(xpath="//*[@id=\'containerNewUserSignup\']/div[2]/div[4]/div/div/div/ul/li[102]/span[1]")
	private static WebElement xpath;

	@FindBy(xpath = "//input[@id='inputCompanyName']")
	private static WebElement companyname;

	@FindBy(xpath = "//input[@id='inputAddress1']")
	private static WebElement inputAddress1;

	@FindBy(xpath = "//input[@id='inputAddress2']")
	private static WebElement inputAddress2;

	@FindBy(xpath = "//input[@id='inputCity']")
	private static WebElement city;

	@FindBy(xpath = "//input[@id='stateinput']")
	private static WebElement states;

	@FindBy(xpath = "//select[@id='inputCountry']")
	private static WebElement country;

	@FindBy(xpath = "//input[@id='inputPostcode']")
	private static WebElement postalcode;

	@FindBy(xpath = "//button[@class='btn btn-default btn-sm generate-password']")
	private static WebElement generatepasswordbtn;

	@FindBy(xpath = "//input[@name='marketingoptin']/../span[2]")
	private static WebElement marketingoption;

	@FindBy(xpath = "//span[@id='recaptcha-anchor']")
	private static WebElement captchacheckbox;

	@FindBy(xpath = "//select[@id='customfield1']/option")
	private static WebElement customfield;

	@FindBy(xpath = "//input[@id='customfield2']")
	private static WebElement customfield1;

	@FindBy(xpath = "//input[@class='btn btn-large btn-primary btn-recaptcha']")
	private static WebElement registerbtn;

	@FindBy(xpath = "//input[@id='inputGeneratePasswordLength']")
	private static WebElement passwordlength;

	@FindBy(xpath = "//button[@class='btn btn-default btn-sm']")
	private static WebElement generatepassword;

	@FindBy(xpath = "//button[@id='btnGeneratePasswordInsert']")
	private static WebElement copypassword;

	@FindBy(xpath = "//input[@id='inputGeneratePasswordOutput']")
	private static WebElement passwordinput;

	@FindBy(xpath = "//section[@id='header']/div/ul/li[3]")
	private static WebElement logoutbtn;

	@FindBy(xpath = "//input[@id='inputEmail']")
	private static WebElement username;

	@FindBy(xpath = "//input[@id='inputPassword']")
	private static WebElement password;

	@FindBy(xpath = "//input[@id='login']")
	private static WebElement loginbtn;
	
	@FindBy(xpath="//div[@class='logo']")
	private static WebElement homepage1;
	
	@FindBy(xpath="//a[text()='Registration']")
	private static WebElement reisterlink;
	


	public String launchapp() {
		String strflag = "Failed";
		try {
			driver.get(BaseTest.getproperty("appUrl1"));
			wait.until(ExpectedConditions.visibilityOf(homepage));
			wait.until(ExpectedConditions.visibilityOfAllElements(account));
			strflag = "Success";

		} catch (Exception e) {
			e.printStackTrace();
			;
		}
		return strflag;
	}

	public String createprofile(LinkedHashMap<String, String> testdata, int rowindex) {

		String strflag = "Failed";
		try {
			clickElement(account);
			waitforsometime(2000);
			wait.until(ExpectedConditions.visibilityOfAllElements(accountoption));
			selectList(accountoption, "Register");
			wait.until(ExpectedConditions.visibilityOf(firstname));
			clickElement(firstname);
			firstname.sendKeys(testdata.get("FirstName"));
			LOGGER.info("Firstname is entered successfully" + testdata.get("FirstName"));
			wait.until(ExpectedConditions.visibilityOf(lastname));
			clickElement(lastname);
			lastname.sendKeys(testdata.get("LastName"));
			LOGGER.info("LastName is entered successfully" + testdata.get("LastName"));

			wait.until(ExpectedConditions.visibilityOf(email));
			clickElement(email);
			email.sendKeys(testdata.get("Email"));
			LOGGER.info("LastName is entered successfully" + testdata.get("Email"));
			clickElement(countryflag);
			waitforsometime(2000);
			//List<WebElement>ls=countryoptions;
			/*
			 * String ele=String.format(countrytxt, "India"); WebElement
			 * xpath=driver.findElement(By.xpath(ele));
			 */
			wait.until(ExpectedConditions.visibilityOf(xpath));
			clickElement(xpath);
			LOGGER.info("Register option is selected sucessfully");
			
			wait.until(ExpectedConditions.visibilityOf(phonenumber));
			clickElement(phonenumber);
			phonenumber.sendKeys(testdata.get("Phonenumber"));
			LOGGER.info("phonenumber is entered successfully" + testdata.get("Phonenumber"));

			wait.until(ExpectedConditions.visibilityOf(companyname));
			clickElement(companyname);
			companyname.sendKeys(testdata.get("Company"));
			LOGGER.info("company is entered successfully" + testdata.get("Company"));

			wait.until(ExpectedConditions.visibilityOf(inputAddress1));
			clickElement(inputAddress1);
			inputAddress1.sendKeys(testdata.get("Streetaddress"));
			LOGGER.info("Address1 is entered successfully" + testdata.get("Streetaddress"));

			wait.until(ExpectedConditions.visibilityOf(inputAddress2));
			clickElement(inputAddress2);
			inputAddress2.sendKeys(testdata.get("StreetAddress1"));
			LOGGER.info("Address2 is entered successfully" + testdata.get("StreetAddress1"));

			wait.until(ExpectedConditions.visibilityOf(city));
			clickElement(city);
			city.sendKeys(testdata.get("City"));
			LOGGER.info("city is entered successfully" + testdata.get("City"));

			wait.until(ExpectedConditions.visibilityOf(states));
			clickElement(states);
			states.sendKeys(testdata.get("State"));
			LOGGER.info("state is entered successfully" + testdata.get("State"));

			wait.until(ExpectedConditions.visibilityOf(postalcode));
			clickElement(postalcode);
			states.sendKeys(testdata.get("postcode"));
			LOGGER.info("postalcode is entered successfully" + testdata.get("postcode"));

			selectdropdown(country, testdata.get("Country"));
			LOGGER.info("country is entered successfully" + testdata.get("Country"));

			wait.until(ExpectedConditions.visibilityOf(customfield1));
			clickElement(customfield1);
			customfield1.sendKeys(testdata.get("Phonenumber"));
			LOGGER.info("whatsAppnumber  is entered successfully" + testdata.get("Phonenumber"));

			wait.until(ExpectedConditions.visibilityOf(generatepasswordbtn));
			clickElement(generatepasswordbtn);
			wait.until(ExpectedConditions.visibilityOf(passwordlength));
			clickElement(passwordlength);
			passwordlength.clear();
			passwordlength.sendKeys("10");
			wait.until(ExpectedConditions.visibilityOf(generatepassword));
			clickElement(generatepassword);
			wait.until(ExpectedConditions.visibilityOf(copypassword));
			clickElement(copypassword);
			String elementval = passwordinput.getAttribute("value");
			//webDriver.findElement(By.id("inputTag")).getAttribute("value")
			updateCellData(System.getProperty("user.dir") + "//src//main//resources//testdata//", "testdata", "profile",
					rowindex, "Password", elementval);
			LOGGER.info("password is generated successfully");
			wait.until(ExpectedConditions.visibilityOf(marketingoption));
			clickElement(marketingoption);
			driver.switchTo().frame(0);
			waitforsometime(1000);
			wait.until(ExpectedConditions.visibilityOf(captchacheckbox));
			clickElement(captchacheckbox);
			waitforsometime(5000);
			driver.switchTo().defaultContent();
			wait.until(ExpectedConditions.visibilityOf(registerbtn));
			clickElement(registerbtn);
			wait.until(ExpectedConditions.visibilityOf(homepage));
			LOGGER.info("Profile is created successfully");
			waitforsometime(3000);
			wait.until(ExpectedConditions.visibilityOf(logoutbtn));
			clickElement(logoutbtn);
			LOGGER.info("Successfully Logged out");
			strflag = "Success";

		} catch (Exception e) {
			e.printStackTrace();
			;
		}
		return strflag;
	}

	public String logintoprofile(LinkedHashMap<String, String> testdata) {
		String strflag = "Failed";
		try {

			clickElement(account);
			wait.until(ExpectedConditions.visibilityOfAllElements(accountoption));
			selectList(accountoption, "Login");
			wait.until(ExpectedConditions.visibilityOf(username));
			username.sendKeys(testdata.get("Email"));
			wait.until(ExpectedConditions.visibilityOf(password));
			password.sendKeys(testdata.get("Password"));
			clickElement(captchacheckbox);
			strflag="Success";

		} catch (Exception e) {
			e.printStackTrace();
			;
		}
		return strflag;
	}
	
	@FindBy(xpath="//input[@name='name']")
	private static WebElement name;
	
	@FindBy(xpath="//input[@name='phone']")
	private static WebElement phone;

	@FindBy(xpath="//input[@name='email']")
	private static WebElement emailid;
	
	@FindBy(xpath="//select[@name='country']")
	private static WebElement countryselection;
	
	@FindBy(xpath="//input[@name='city']")
	private static WebElement cityname;
	
	@FindBy(xpath="(//input[@name='username'])[2]")
	private static WebElement usrname;
	
	@FindBy(xpath="(//input[@name='password'])[2]")
	private static WebElement passwordtxt;
	
	@FindBy(xpath="(//input[@class='button'])[2]")
	private static WebElement submitbtn;
	
	public String createprofile1(LinkedHashMap<String, String> testdata, int rowindex) {
		String strflag = "Failed";
		try {
			
			selectdropdown(countryselection,"India");
			strflag="Success";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return strflag;
	}

}
