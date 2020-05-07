package reports;

import java.io.File;

import com.cucumber.listener.Reporter;







public class ExtentReport {

	public static void writeExtentReport() {

		String reportConfigPath = System.getProperty("user.dir") + "/src/main/resources/extent-config.xml";
		Reporter.loadXMLConfig(new File(reportConfigPath));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
		Reporter.setSystemInfo("Selenium", "3.7.0");
		Reporter.setSystemInfo("Maven", "3.5.2");
		Reporter.setSystemInfo("Java Version", "1.8.0_151");

	}

}
