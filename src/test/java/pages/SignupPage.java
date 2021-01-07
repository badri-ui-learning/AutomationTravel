package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage 
{
	WebDriver driver;
	
	// BELOW ARE THE XPATHs OF ALL THE ELEMENTS FROM OUR TESTCASES
	By yourName_Textbox = By.xpath("//input[@placeholder='Your name']");
	By email_Textbox = By.xpath("//input[@placeholder='Email']");
	By mobileNumber_Textbox = By.xpath("//input[@placeholder='Mobile Number']");
	By createMyAccount_Button = By.xpath("//button[text()='Create my account']");
	By missingName_Error = By.xpath("//span[text()='Enter your name']");
	By missingEmail_Error = By.xpath("//span[text()='Enter your mail address']");
	By missingMobileNumber_Error = By.xpath("//span[text()='Enter your valid mobile number']");
	By invalidEmail_Error = By.xpath("//span[text()='Entered email is not valid']");
	
	public SignupPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	// BELOW ARE THE ACTIONS FROM OUR TESTCASES. WRITTEN IN THE FORM OF FUNCTIONS
	public void enterYourName(String name)
	{
		driver.findElement(yourName_Textbox).sendKeys(name);
	}
	
	public void enterEmail(String email)
	{
		driver.findElement(email_Textbox).sendKeys(email);
	}
	
	public void enterMobileNumber(String mobile)
	{
		driver.findElement(mobileNumber_Textbox).sendKeys(mobile);
	}
	
	public void clickCreateMyAccountButton()
	{
		driver.findElement(createMyAccount_Button).click();
	}
	
	public boolean isExistsMissingNameError()
	{
		if(driver.findElement(missingName_Error).isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	public boolean isExistsMissingEmailError()
	{
		if(driver.findElement(missingEmail_Error).isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	public boolean isExistsMissingMobileNumberError()
	{
		if(driver.findElement(missingMobileNumber_Error).isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	public boolean isExistsInvalidEmailError()
	{
		if(driver.findElement(invalidEmail_Error).isDisplayed())
		{
			return true;
		}
		return false;
	}
}
