package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class MyAccountPage extends BasePage
{
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[contains(text(),'My Account')]") WebElement title_MyAccount;
	
	@FindBy(xpath="//div[@class='list-group mb-3']//a[text()='Logout']") WebElement link_Logout;
	
	public boolean ValidateMyAccountLink()
	{
		try
		{
			return(title_MyAccount.isDisplayed()); 
		}
		catch(Exception e)
		{
			return(false);
		}
		
	}
	
	public void clickLogout() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", link_Logout);
		
	}
	

}
