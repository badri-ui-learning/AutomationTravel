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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SignupPage;

public class SignupTestcase extends BaseTest
{
	boolean result;
	
	SignupPage obj;
	
	@BeforeMethod(alwaysRun = true)
	public void gotoSignuppage() throws Exception
	{
		driver.get("https://pickyourtrail.com/signup");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		obj = new SignupPage(driver);
	}
	
	@Test
	public void CLickLoginWithoutCredentials() throws Exception
	{
		obj.clickCreateMyAccountButton();
		Thread.sleep(2000);
		if(obj.isExistsMissingNameError()&&obj.isExistsMissingMobileNumberError()&&obj.isExistsMissingEmailError())
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
	public void invalidEmailFormat() throws Exception
	{
		obj.enterMobileNumber("9009001234");
		obj.enterEmail("badri");
		obj.enterYourName("Automation");
		obj.clickCreateMyAccountButton();
		Thread.sleep(2000);
		if(obj.isExistsInvalidEmailError())
		{
			result = true;
		}
		else
		{
			result = false;
		}
		AssertJUnit.assertTrue(result);
	}
	
	@AfterMethod(alwaysRun = true)
	public void takeScreenshot() throws Exception
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime now = LocalDateTime.now();
		
		String currTime = dtf.format(now);
		System.out.println("Printing Current Date");
		System.out.println(currTime);
		
		currTime = "/Users/badrinarayananr/Selenium-Workspace/AutomationTravel/screenshots/Signup/"+currTime+".png";
		System.out.println("Current Time Folder is "+currTime);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(currTime);
		org.apache.commons.io.FileUtils.copyFile(src, dest);
	}
	
}
