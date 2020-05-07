package pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cucumber.listener.Reporter;

import stepdefinitions.ProfilecreationTest;
import util.BaseTest;

public class AdminPage extends BaseTest {

	private static Logger LOGGER = Logger.getLogger(AdminPage.class.getName());

	final WebDriver driver;

	public AdminPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='content-header']/h1")
	public static WebElement headertext;
	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(AdminPage.class);

	@FindBy(xpath = "//div[@class='page login-page']/div/h1")
	private static WebElement titlepage;

	@FindBy(xpath = "//input[@class='email']")
	private static WebElement email;

	@FindBy(xpath = "//input[@class='password']")
	private static WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	private static WebElement loginbtn;

	@FindBy(xpath = "//ul[@class='sidebar-menu tree']/li")
	public static List<WebElement> dashboardlist;

	public static String productlist = "//ul[@class='treeview-menu']/li/a//span[text()='Products']";

	@FindBy(xpath = "//div[@class='search-text']")
	private static WebElement searchpage;

	@FindBy(xpath = "//input[@id='SearchProductName']")
	private static WebElement searchinput;

	@FindBy(xpath = "//button[@id='search-products']")
	private static WebElement searchbtn;

	private static String productname = "//table[@id='products-grid']/tbody/tr/td[3][text()='$100 Physical Gift Card']";

	String HEADERTEXT = "Dashboard";

	public String loginadminpage(String username, String pwd) {

		String strflag = "failed";

		try {
			wait.until(ExpectedConditions.visibilityOf(titlepage));
			String text = titlepage.getText().trim();
			Assert.assertEquals(text, "Admin area demo");
			Reporter.addStepLog("AdminPage is opened successfully");
			wait.until(ExpectedConditions.visibilityOf(email));
			clickElement(email);
			email.clear();
			email.sendKeys(username);
			Reporter.addStepLog("Email is entered successfully");
			wait.until(ExpectedConditions.visibilityOf(password));
			clickElement(password);
			password.clear();
			password.sendKeys(pwd);
			Reporter.addStepLog("Password is entered successfully");
			wait.until(ExpectedConditions.visibilityOf(loginbtn));
			clickElement(loginbtn);
			LOGGER.info("Loginpage is sucessful");
			strflag = "Success";
			capturscreenshot("loginSuccessful");
			Reporter.addStepLog("AdminPage is Logged successfully");
		} catch (Exception e) {
			e.printStackTrace();
			;
		}
		return strflag;

	}

	public String verfyhomepage() {

		String strflag = "failed";

		try {
			wait.until(ExpectedConditions.visibilityOf(headertext));
			Assert.assertEquals(HEADERTEXT, headertext.getText().trim());
			strflag = "Success";
		} catch (Exception e) {
			e.printStackTrace();
			;
		}
		return strflag;
	}

	public String searchproduct(String dashboard, String productname, String value) {
		String strflag = "failed";
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(headertext));
			Assert.assertEquals(true, headertext.isDisplayed());
			LOGGER.info("dasboard is selected");
			selectList(dashboardlist, dashboard);
			Reporter.addStepLog("Dashboard is selected successfullt" + dashboard);
			selectList(dashboardlist, dashboard);
			LOGGER.info("ProductList is selected");
			Reporter.addStepLog("ProductList is selected successfullt" + dashboard);
			selectProduct(productlist, productname);
			LOGGER.info("productValue is selected");
			Reporter.addStepLog("Productname is selected successfullt" + productname);
			wait.until(ExpectedConditions.visibilityOf(searchpage));
			Assert.assertEquals(true, searchinput.isDisplayed());
			clickElement(searchinput);
			searchinput.sendKeys(value);
			Assert.assertEquals(true, searchbtn.isEnabled());
			clickElement(searchbtn);
			strflag = "Success";
		} catch (Exception e) {
			e.printStackTrace();
			;
		}
		return strflag;
	}

	@FindBy(xpath = "//*[@id='products-grid']/tbody/tr/td[3]")
	private static WebElement resultproduct;

	public String veridyproductvalue(String product) {
		String strflag = "failed";
		try {
			wait.until(ExpectedConditions.visibilityOf(resultproduct));
			String text = resultproduct.getText().trim();
			Assert.assertEquals(text, product);
			Reporter.addStepLog("Product is verified successfully");
			strflag = "Success";
		} catch (Exception e) {
			e.printStackTrace();
			;
		}
		return strflag;

	}

	public void selectProduct(String xpath, String text) {
		String productxpath = String.format(xpath, text);
		WebElement ele = driver.findElement(By.xpath(productxpath));
		Assert.assertEquals(true, ele.isDisplayed());
		clickElement(ele);

	}

	public LoginPage checkonpage() {
		waitforsometime(1000);
		return PageFactory.initElements(driver, LoginPage.class);
	}

	public ProfilecreationTest checkonpage1() {
	waitforsometime(1000);
	return PageFactory.initElements(driver, ProfilecreationTest.class);
}
}
