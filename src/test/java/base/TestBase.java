package base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import testcases.LoginPageTestCases;
import utils.ConfigReader;

public class TestBase {

	static protected WebDriver driver;
	protected ConfigReader config;
	Logger log=Logger.getLogger(TestBase.class);

	@Parameters({"browser", "appUrl"})
	@BeforeMethod(alwaysRun=true)
	public void login(String brOption, String url)
	{
		log=Logger.getLogger(TestBase.class);
		log.info("********initializing********");
		log.info("initailizing the properties of file");
         config = new ConfigReader();
		if(brOption.equals("chrome")) {
			
			System.setProperty(config.getChromeKey(), "./BrowserDriver/chromedriver.exe");
			System.out.println("*************** Setting up Browser ********************");
			driver = new ChromeDriver();
		}
		else if (brOption.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./BrowserDriver/geckodriver.exe");
			System.out.println("*************** Setting up Browser ********************");
			driver = new FirefoxDriver();
		}
		
		System.out.println("*************** Initializing Browser ********************");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(url);

		System.out.println("Navigated to appurl " + url);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
		System.out.println("******************** CLOSING THE BROWSER **************");
	}
}
