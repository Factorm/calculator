package tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.calculatorPage;
import tools.BrowserFactory;
import tools.ExcelFactory;
import tools.ExtentManager;
import tools.ResultFactory;
import tools.Screenshots;

public class calculatorPowerTest {

	public WebDriver driver;
	public ExtentTest test;
	public ExtentReports report;
	private calculatorPage cp;

	@BeforeMethod
	public void beforeMethod(Method method) throws Exception {
		report = ExtentManager.getInstance();
		test = report.startTest(this.getClass().getSimpleName() + " :: " + method.getName());
		
		driver = BrowserFactory.startBrowser("chrome", "http://localhost:81/");
		test.log(LogStatus.INFO, "Browser is started...");
	}

	@AfterMethod
	public void afterMethod(ITestResult testResult, Method method) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			String path = Screenshots.takeScreenshot(driver, testResult.getName());
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, testResult.getTestName() + " FAILED", imagePath);
		} else {
			test.log(LogStatus.PASS, this.getClass().getSimpleName() + " :: " + method.getName() + " PASSED");
		}
		driver.quit();
		test.log(LogStatus.INFO, "Browser is closed...");
		report.endTest(test);
		report.flush();
	}
	
	@DataProvider(name = "powData")
	public Object[][] dataProvider() throws Exception {
		String File_Path = System.getProperty("user.dir") + "//data//";
		String File_Name = "data.xlsx";
		
		Object[][] testData = ExcelFactory.getTableArray(File_Path + File_Name, "Arkusz1");
		return testData;
	}

	@Test(dataProvider="powData")
	public void shouldPowerTwoNumbers(String value1, String value2)  throws Exception {
		
		cp = new calculatorPage(driver, test);
		
		cp.power(value1, value2);
		
		Assert.assertTrue(ResultFactory.checkTheResult(value1, value2, "POWER(^)", cp.result()));
	}

}