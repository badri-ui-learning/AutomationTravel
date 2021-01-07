package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.LoginPage;

public class LoginTestcase extends BaseTest
{
	boolean result;
	LoginPage obj;
	String expected = "https://pickyourtrail.com/login";
	
	@BeforeMethod(alwaysRun = true)
	public void gotoLoginpage() throws Exception
	{
		driver.get("https://pickyourtrail.com/login");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		obj = new LoginPage(driver);
	}
	
	@Test
	public void noCredentialsVerification() throws Exception
	{
		obj.clickLoginButton();
		Thread.sleep(2000);
		if(obj.isExistsCredentialsMissingError())
		{
			result = true;
		}
		else
		{
			result = false;
		}
		
	}
	
	@Test
	public void loginWithInvalidCredentials() throws Exception
	{
		obj.enterMobileNumber("38746459867459867");
		obj.enterPassword("purhgurehgug");
		obj.clickLoginButton();
		Thread.sleep(2000);
			
		if(obj.isExistsInvalidMobileError())
		{
			result = true;
		}
		else
		{
			result = false;
		}
		AssertJUnit.assertTrue(result);
	}
	
	@Test
	public void checkURL()
	{
		String actual = obj.fetchURL();
		AssertJUnit.assertEquals(expected, actual);
	}
	
	@AfterMethod(alwaysRun = true)
	public void takeScreenshot() throws Exception
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime now = LocalDateTime.now();
		
		String currTime = dtf.format(now);
		System.out.println("Printing Current Date");
		System.out.println(currTime);
		
		currTime = "/Users/badrinarayananr/Selenium-Workspace/AutomationTravel/screenshots/Login/"+currTime+".png";
		System.out.println("Current Time Folder is "+currTime);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(currTime);
		org.apache.commons.io.FileUtils.copyFile(src, dest);
	}
	
}
