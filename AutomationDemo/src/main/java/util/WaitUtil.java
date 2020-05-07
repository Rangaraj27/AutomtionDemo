package util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitUtil {

	private static WebDriver driver;

	WebDriverWait wait = new WebDriverWait(driver, 60);

	public static boolean clickElement(WebElement locator) {
		boolean status = true;
		JavascriptExecutor je = (JavascriptExecutor) driver;

		try {
			WebElement ele = locator;
			ele.click();
			BaseTest.captureScreenshot("Locatorclicked");
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

	public static void waitforsometime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
