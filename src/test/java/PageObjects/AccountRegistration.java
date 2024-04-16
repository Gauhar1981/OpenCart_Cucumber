package PageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistration extends BasePage
{

	public AccountRegistration(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(id="input-firstname") WebElement txt_FirstName;
	@FindBy(id="input-lastname") WebElement txt_LastName;	
	@FindBy(id="input-email") WebElement txt_Email;
	@FindBy(id="input-password") WebElement txt_Password;
	//@FindBy(id="input-newsletter-yes") WebElement RdBtn_Yes;
	@FindBy(name="agree") WebElement ChkdPolicy;
	
	@FindBy(xpath="//button[contains(text(),'Continue')]") WebElement btnContinue;
	
	@FindBy(xpath="//div[@id='content']//h1") WebElement msg_Confirm;
	
	public void SetFirstName(String fname)
	{
		txt_FirstName.sendKeys(fname);
	}
	
	public void SetLastName(String lname)
	{
		txt_LastName.sendKeys(lname);
	}
	
	public void SetEmail(String email)
	{
		txt_Email.sendKeys(email);
	}
	
	public void SetPassword(String pwd)
	{
		txt_Password.sendKeys(pwd);
	}
	
	/*public void setNewsLetter()
	{
		RdBtn_Yes.click();
	}*/
	
	public void setPrivacyPolicy()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ChkdPolicy);
		//ChkdPolicy.click();
	}
	
	public void clickContinue()
	{
		//sol1 
		//btnContinue.click();
		
		//sol2 
		//btnContinue.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
					
		//sol4
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", btnContinue);
		
		
		//Sol 5
		//btnContinue.sendKeys(Keys.RETURN);
		
		//Sol6  
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		
	}
	
	public String getConfirmationMessage()
	{
		
		
		try
		{
		return msg_Confirm.getText();
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	
}


