package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class calculatorPage {

	private WebDriver driver = null;
	private ExtentTest test = null;

	public calculatorPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "1field")
	WebElement firstField;

	@FindBy(id = "2field")
	WebElement secondField;

	@FindBy(id = "op")
	WebElement listOption;

	@FindBy(id = "button")
	WebElement button;

	@FindBy(id = "t3")
	WebElement resultWindow;

	public void enterFirstField(String value) {
		firstField.sendKeys(value);
		test.log(LogStatus.INFO, "To (firstField :: " + firstField.getLocation() + ") add: " + value);
	}

	public void enterSecondField(String value) {
		secondField.sendKeys(value);
		test.log(LogStatus.INFO, "To (secondFieldd :: " + secondField.getLocation() + ") add: " + value);
	}

	public void selectMathematicalAction(String select) {
		List<WebElement> results = listOption.findElements(By.tagName("option"));

		for (WebElement result : results) {
			if (result.getText().equals(select)) {
				result.click();
				break;
			}
		}
		test.log(LogStatus.INFO, "A mathematical method has been chosen: " + select);
	}
	
	public void clickButton(){
		button.click();
		test.log(LogStatus.INFO, "The button has been pressed");
	}

	public void addition(String value1, String value2) {
		firstField.sendKeys(value1);
		secondField.sendKeys(value2);
		selectMathematicalAction("ADD(+)");
		clickButton();		
	}

	public void subtraction(String value1, String value2) {
		firstField.sendKeys(value1);
		secondField.sendKeys(value2);
		selectMathematicalAction("SUBTRACT(-)");
		clickButton();	
	}

	public void multiplication(String value1, String value2) {
		firstField.sendKeys(value1);
		secondField.sendKeys(value2);
		selectMathematicalAction("MULTIPLY(*)");
		clickButton();	
	}

	public void division(String value1, String value2) {
		firstField.sendKeys(value1);
		secondField.sendKeys(value2);
		selectMathematicalAction("DIVIDE(/)");
		clickButton();	
	}

	public void power(String value1, String value2) {
		firstField.sendKeys(value1);
		secondField.sendKeys(value2);
		selectMathematicalAction("POWER(^)");
		clickButton();	
	}

	public String result() {
		test.log(LogStatus.INFO, "The result is: " + resultWindow.getAttribute("value"));
		return resultWindow.getAttribute("value");
	}

}
