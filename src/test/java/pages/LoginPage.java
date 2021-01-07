package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
   public WebDriver driver;
   
   By mobileNumber_Textbox = By.xpath("//input[@placeholder='Mobile Number']");
   By password_Textbox = By.xpath("//input[@placeholder='Password']");
   By login_Button = By.xpath("//button[text()='Login']");
   By credentialsMissing_Error = By.xpath("//span[text()='Enter your registered mobile number and password']");
   By invalidMobile_Error = By.xpath("//span[text()='Registered mobile number is not valid']");
   
   public LoginPage(WebDriver driver)
   {
	   this.driver = driver;
   }
   
   public void enterMobileNumber(String mobileNumber)
   {
	   driver.findElement(mobileNumber_Textbox).sendKeys(mobileNumber);
   }
   
   public void enterPassword(String password)
   {
	   driver.findElement(password_Textbox).sendKeys(password);
   }
   
   public void clickLoginButton()
   {
	   driver.findElement(login_Button).click();
   }
   
   public boolean isExistsCredentialsMissingError()
   {
	   if(driver.findElement(credentialsMissing_Error).isDisplayed())
	   {
		   return true;
	   }
	   return false;
   }
   
   public boolean isExistsInvalidMobileError()
   {
	   if(driver.findElement(invalidMobile_Error).isDisplayed())
	   {
		   return true;
	   }
	   return false;
   }
   
   public String fetchURL()
   {
	   String title = driver.getCurrentUrl();
	   return title;
   }
   
}
