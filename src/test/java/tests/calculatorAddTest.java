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

public class calculatorAddTest {
	
	private WebDriver driver = null;
	private ExtentTest test = null;
	private ExtentReports report = null;
	private calculatorPage calculatorPage = null;
	private ResultFactory resultFactory = null;

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
	
	@DataProvider(name = "numberData")
	public Object[][] dataProvider() throws Exception {
		String file_Path = System.getProperty("user.dir") + "//data//";
		String file_Name = "data.xlsx";
		
		Object[][] oTestData = ExcelFactory.getTableArray(file_Path + file_Name, "Arkusz1");
		return oTestData;
	}
	
	@DataProvider(name = "wordData")
	public Object[][] dataProvider2() throws Exception {
		String file_Path = System.getProperty("user.dir") + "//data//";
		String file_Name = "data.xlsx";
		
		Object[][] oTestData = ExcelFactory.getTableArray(file_Path + file_Name, "Arkusz2");
		return oTestData;
	}

	@Test(dataProvider="numberData")
	public void shouldAddTwoNumbers(String value1, String value2)  throws Exception {
		
		calculatorPage = new calculatorPage(driver, test);
		
		calculatorPage.addition(value1, value2);
		
		resultFactory = new ResultFactory(test);
		Assert.assertTrue(resultFactory.checkTheResult(value1, value2, "ADD(+)", calculatorPage.result()));
	}
	
	@Test(dataProvider="wordData")
	public void shouldntAddTwoWords(String sValue1, String sValue2)  throws Exception {
		
		calculatorPage = new calculatorPage(driver, test);
		
		calculatorPage.addition(sValue1, sValue2);
		
		resultFactory = new ResultFactory(test);
		Assert.assertTrue(resultFactory.checkTheResultWord(calculatorPage.result()));
	}

}
