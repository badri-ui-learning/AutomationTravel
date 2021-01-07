package testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;

public class BaseTest 
{
   protected WebDriver driver;
   
   @Parameters({"browser"})
   @BeforeTest(alwaysRun = true)
   public void launchBrowser(@Optional("chrome") String browser) throws MalformedURLException
   {	   	   
//	   if(browser.equalsIgnoreCase("chrome"))
//	   {
//		   System.setProperty("webdriver.chrome.driver", "/Users/badrinarayananr/Agile_Batch2/Selenium_Downloads/chromedriver");
//		   driver = new ChromeDriver();
//		   driver.manage().window().maximize();	
//	   }
//	   
//	   if(browser.equalsIgnoreCase("firefox"))
//	   {
//		   System.setProperty("webdriver.gecko.driver", "/Users/badrinarayananr/Agile_Batch2/Selenium_Downloads/geckodriver");
//		   driver = new FirefoxDriver();
//		   driver.manage().window().maximize();	
//	   }
	   
	   
	   DesiredCapabilities dc=null;
		String host = "localhost";
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			dc = DesiredCapabilities.chrome();
		}
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			dc = DesiredCapabilities.firefox();
		}
			
		String completeUrl = "http://"+host+":4444/wd/hub";
		this.driver = new RemoteWebDriver(new URL(completeUrl),dc);
	   
	   
   }
   
   @AfterTest(alwaysRun = true)
   public void closeBrowser()
   {
	   this.driver.quit();
   }
}
