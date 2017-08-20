package tools;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	static WebDriver driver;

	public static WebDriver startBrowser(String browserName, String url) {

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C://Selenium//chromedriver.exe");

			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"C://Selenium//geckodriver.exe");

			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);

		return driver;
	}

}
