package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
     WebDriver driver;
	public HomePage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//span[contains(text(),'My Account')]") WebElement linkMyAccount;
	
	@FindBy(xpath="//ul[@data-popper-placement='bottom-start']//li[1]//a[1]") WebElement linkRegister;
	
	@FindBy(xpath="//a[text()='Login']") WebElement linkLogin;
	
	@FindBy(xpath="//input[@placeholder='Search']")  //For Search Product Test
	WebElement txtSearchbox;

	@FindBy(xpath="//div[@id='search']//button[@type='button']") //For Search Product Test
	WebElement btnSearch;
	
	public void clickMyAccount()
	{
		linkMyAccount.click();
	}
	
	public void ClickRegister()
	{
		linkRegister.click();
	}
	
	public void ClickLogin()
	{
	  linkLogin.click();
	}
        
       public void enterProductName(String pName)   //For Search Product Test
       {
	     txtSearchbox.sendKeys(pName);
       }

       public void clickSearch()  //For Search Product Test
       {
	      btnSearch.click();
       }

}
