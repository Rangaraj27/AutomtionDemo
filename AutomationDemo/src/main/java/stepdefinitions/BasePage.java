package stepdefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.BaseTest;



public class BasePage {

	public static WebDriver driver;

	public static WebDriverWait wait;

//	final static Logger Log = Log4j.getLogData(Log4j.class.getName());
//	private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
	private static Logger LOGGER = Logger.getLogger(BasePage.class.getName());

	public static void initdriver() {

		String OS = System.getProperty("os.name");
		System.out.println(OS);
		if (OS.contentEquals("Windows 10")) {
				System.setProperty("webdriver.chrome.driver", BaseTest.getproperty("chromepath"));
				ChromeOptions options = new ChromeOptions();
				//options.addExtensions(new File("C:\\Users\\rangaraj\\Downloads\\extension_1_2_0_0.crx"));
				options.addArguments("start-maximized");
				// options.addArguments("headless");
				//options.addArguments("disable-extensions");
				driver = new ChromeDriver(options);
				LOGGER.info("Chrome browser is launched successfully");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				LOGGER.info("Implicit wait applied on the driver for 10 seconds");
				// driver.get("http://www.shop.demoqa.com");
			/*
			 * } else if(parameter.equalsIgnoreCase("ie")) {
			 * System.setProperty("webdriver.ie.driver",
			 * BaseTest.getproperty("iedriverpath")); driver = new InternetExplorerDriver();
			 * driver.manage().window().maximize();
			 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); } else {
			 * driver =new FirefoxDriver(); driver.manage().window().maximize();
			 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); }
			 */
		} else {
			System.out.println("different os" + OS);
		}
		wait = new WebDriverWait(driver, 60);
	}

	
}
