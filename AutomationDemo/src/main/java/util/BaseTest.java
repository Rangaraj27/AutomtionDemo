package util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import pageobjects.AdminPage;
import pageobjects.LoginPage;
import stepdefinitions.AdminTest;
import stepdefinitions.BasePage;


public class BaseTest extends BasePage {
	
	private static Logger LOGGER = Logger.getLogger(BaseTest.class.getName());
	public static DateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmmss");
	public static String scenariopath;
	public static LoginPage login1;
	public static AdminPage login;
	public LinkedHashMap<String,String>testdata;
	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;

	
	//ArrayList<>
	

	public BaseTest() {
		this.driver = BasePage.driver;
	}

	public AdminPage startScenario() {
		initdriver();
		driver.get(getproperty("appUrl"));
		return (PageFactory.initElements(driver, AdminPage.class));
	}
	
	public static void stopExecution()
	{
		System.out.println("After hook running");
		System.out.println("Close browser");
		driver.quit();
	}

	
	@SuppressWarnings("finally")
	public static String getproperty(String text) {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			String dir = System.getProperty(("user.dir")) + "//src//main//resources//config//configuration.properties";
			input = new FileInputStream(dir);
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (input != null) {
				try {
					input.close();
				} catch (Exception e) {
					System.out.println(e);

				}
			}
			return prop.getProperty(text);
		}

	}

	

	public static String captureScreenshot(String scenariopath) {
		//String path = System.getProperty("user.dir") + "/screenshot";
		Date date = new Date();
		String snaptime = dateformat.format(date);
		String result="false";
		try {
			WebDriver augumentdriver = new Augmenter().augment(driver);
			File source = ((TakesScreenshot) augumentdriver).getScreenshotAs(OutputType.FILE);
			String currentDate = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss").format(new Date());
			String path =".//screenshots//" + scenariopath+"_"+ snaptime + ".png";
			final BufferedImage image = ImageIO.read(source);
			Graphics g = image.getGraphics();
			g.setFont(g.getFont().deriveFont(20f));
			g.setColor(Color.GREEN);
			g.drawString(currentDate, 20, 20);
			g.dispose();
			ImageIO.write(image, "png", new File(path));
			result= path;
		} catch (Exception e) {
			System.out.println("Unable to take screenshot");
		}
		return result;

	}

	public static void capturscreenshot(String scenario) {
System.out.println("screenshot method");
		Date date = new Date();
		String screenshotName = scenario.trim();
		String snaptime = dateformat.format(date);
		try {
			// This takes a screenshot from the driver at save it to the specified location
			// File sourcePath = ((TakesScreenshot)
			// testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// Building up the destination path for the screenshot to save
			// Also make sure to create a folder 'screenshots' with in the cucumber-report
			// folder
			File destinationPath = new File(
					System.getProperty("user.dir") + "target/cucumber-reports/screenshots/" + screenshotName + "_"+ snaptime+ ".png");

			// Copy taken screenshot from source location to destination location
			Files.copy(file, destinationPath);

			// This attach the specified screenshot to the test
			//Reporter.addScreenCaptureFromPath(destinationPath.toString());
		} catch (IOException e) {
		}

	}


	public static boolean clickElement(WebElement locator) {
		boolean status = true;
		JavascriptExecutor je = (JavascriptExecutor) driver;

		try {
			WebElement ele = locator;
			ele.click();
			//capturscreenshot("Locatorclicked");
		} catch (ElementNotVisibleException e) {
			try {

				WebElement ele = locator;
				je.executeScript("arguments[0].scrollIntoView(true);", ele);
				ele.click();
				return true;
			} catch (StaleElementReferenceException e1) {
				e1.printStackTrace();
				return false;
			}

			catch (Exception e2) {
				e.printStackTrace();
			}
		} catch (WebDriverException e3) {
			try {
				WebElement ele = locator;
				je.executeScript("arguments[0].scrollIntoView(true);", ele);
				ele.click();
				return true;
			} catch (Exception e4) {
				e4.printStackTrace();
			}
		}

		return false;

	}
	
	public static void waitforsometime(int time)
	{
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void selectList(List<WebElement> ele,String text)
	{
		List<WebElement>ls=ele;
		for(WebElement list:ls)
		{
			if(list.getText().trim().equals(text))
			{
				list.click();
				LOGGER.info("Register option is selected sucessfully");
				break;
			}
		}
	}
	
	public static int getrowIndex(String filepath, String workbookname, String sheetname, String rowid)
			throws IOException {

		FileInputStream file = new FileInputStream(new File(filepath + "/" + workbookname + ".xlsx"));
		ExcelWBook = new XSSFWorkbook(file);
		ExcelWSheet = ExcelWBook.getSheet(sheetname);
		DataFormatter formatter = new DataFormatter();
		//String val = formatter.formatCellValue(sheet.getRow(row).getCell(col));
		boolean check = true;
		int i = 1;
		while (check) {
			Row = ExcelWSheet.getRow(i);
			String Cellvalue = (Row.getCell(0).getStringCellValue());
			if (Cellvalue.equals(rowid)) {
				check = false;
			} else {
				i = i + 1;
			}
		}
		return i;

	}

	public static  LinkedHashMap<String, String> getrowdata(String filepath, String workbookname, String sheetname,
			int rowindex) throws Exception {
		FileInputStream file = new FileInputStream(new File(filepath + "/" + workbookname + ".xlsx"));
		ExcelWBook = new XSSFWorkbook(file);
		ExcelWSheet = ExcelWBook.getSheet(sheetname);
		Row=ExcelWSheet.getRow(rowindex);
		XSSFRow headerRow=ExcelWSheet.getRow(0);
		LinkedHashMap<String,String>data=new LinkedHashMap<String,String>();
		int firstcell=headerRow.getFirstCellNum();
		int lastcell=headerRow.getLastCellNum();
		XSSFCell cell1=headerRow.getCell(firstcell);
		XSSFCell cell2=Row.getCell(firstcell);
		
		for(int i=firstcell;i<lastcell;i++)
		{
			cell1=headerRow.getCell(i);
			cell2=Row.getCell(i);
			String headerValue=cell1.getStringCellValue();
			String fieldValue;
			if(cell2==null)
			{
				fieldValue="";
			}
			else
			{
				fieldValue=cell2.getStringCellValue();
			}
			data.put(headerValue,fieldValue);
			}
		file.close();
		return data;
	}
	
	public static boolean updateCellData(String filepath, String workbookname, String sheetname,
			int rowindex,String colHeader,String cellValueToUpdate) throws Exception
	{
		FileInputStream file = new FileInputStream(new File(filepath + "/" + workbookname + ".xlsx"));
		ExcelWBook = new XSSFWorkbook(file);
		ExcelWSheet = ExcelWBook.getSheet(sheetname);
		Row=ExcelWSheet.getRow(rowindex);
		XSSFRow headerRow=ExcelWSheet.getRow(0);
		int firstcell=headerRow.getFirstCellNum();
		int lastcell=headerRow.getLastCellNum();		
		for(int i=firstcell;i<lastcell;i++)
		{
			if(headerRow.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colHeader))
			{
				Row.getCell(i).setCellValue(cellValueToUpdate);
			}
		}
		file.close();
		FileOutputStream outfile = new FileOutputStream(new File(filepath + "/" + workbookname + ".xlsx"));
		ExcelWBook.write(outfile);
		return true;
		
	}

	public static void selectdropdown(WebElement element,String text)
	{
		Select dropdown= new Select(element);
		dropdown.selectByVisibleText(text);
	}
	
	public String getscreenshot(String screenshotName) {
	
		 try {
		 //This takes a screenshot from the driver at save it to the specified location
			 TakesScreenshot ts = (TakesScreenshot) driver;
			 File source = ts.getScreenshotAs(OutputType.FILE);
		 //File sourcePath = ((TakesScreenshot) ((Object) driver).getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
		 
		 //Building up the destination path for the screenshot to save
		 //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
		 File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
		 
		 //Copy taken screenshot from source location to destination location
		 Files.copy(source, destinationPath);   
		 
		 //This attach the specified screenshot to the test
		 Reporter.addScreenCaptureFromPath(destinationPath.toString());
		 } catch (IOException e) {
		 }
		return screenshotName; 
	}
}
