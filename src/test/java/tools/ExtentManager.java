package tools;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	public static ExtentReports getInstance() {
		ExtentReports extent;
		String Path = System.getProperty("user.dir") + "//test-output//LOGs.html";
		extent = new ExtentReports(Path, false);
		extent.addSystemInfo("Selenium Version", "3.4.0").addSystemInfo("Platform", "Windows 10");
		
		return extent;
	}

}
