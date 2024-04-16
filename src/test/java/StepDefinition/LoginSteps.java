package StepDefinition;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import Utilities.DataReader;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps {
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MyAccountPage myacp;
	
	List<HashMap<String, String>> datamap; //Data driven
	
	@Given("user navigates to login page")
	public void user_navigates_to_login_page() {
		BaseClass.getLogs().info("Go to My Account menu --> click login");
		hp=new HomePage(BaseClass.getDriver());
		hp.clickMyAccount();
		hp.ClickLogin();
	}
	
	@When("user enter email as  {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {
BaseClass.getLogs().info("***Executing Login Scenario******");
		
        BaseClass.getLogs().info("Entering email and password.. ");
   	
   	lp=new LoginPage(BaseClass.getDriver());
      	lp.setEmail(email);
       lp.setPassword(password);
	}
	
	@When("user clicks on Login button")
	public void user_clicks_on_Login_button() 
	{
		lp.setLoginClick();
		BaseClass.getLogs().info("Clicked Login button.....");
	}

	@Then("user should navigate to MyAccount page")
	public void user_should_navigate_to_my_account_page()
	{
       myacp=new MyAccountPage(BaseClass.getDriver());
       boolean targetpage=myacp.ValidateMyAccountLink();
       Assert.assertEquals(targetpage, true);
       BaseClass.getLogs().info("My Account Link validated successfully.....");
       
       BaseClass.getLogs().info("***Login Scenario is passed");
	}
       
	
	//Data Driven Test Excel
	
	 @Then("the user should be redirected to the MyAccount Page by passing email and password with excel row {string}")
	    public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_data(String rows)
	    {
	        datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\Opencart_LoginData.xlsx", "Sheet1");

	        int index=Integer.parseInt(rows)-1;
	        String email= datamap.get(index).get("username");
	        String pwd= datamap.get(index).get("password");
	        String exp_res= datamap.get(index).get("res");

	        lp=new LoginPage(BaseClass.getDriver());
	        lp.setEmail(email);
	        lp.setPassword(pwd);

	        lp.setLoginClick();
	        myacp=new MyAccountPage(BaseClass.getDriver());
	        try
	        {
	            boolean targetpage=myacp.ValidateMyAccountLink();
	            System.out.println("target page: "+ targetpage);
	            if(exp_res.equals("Valid"))
	            {
	                if(targetpage==true)
	                {
	                    MyAccountPage myaccpage=new MyAccountPage(BaseClass.getDriver());
	                    myaccpage.clickLogout();
	                    Assert.assertTrue(true);
	                }
	                else
	                {
	                    Assert.assertTrue(false);
	                }
	            }

	            if(exp_res.equals("Invalid"))
	            {
	                if(targetpage==true)
	                {
	                    myacp.clickLogout();
	                    Assert.assertTrue(false);
	                }
	                else
	                {
	                    Assert.assertTrue(true);
	                }
	            }


	        }
	        catch(Exception e)
	        {

	            Assert.assertTrue(false);
	        }
	      }
	 


}
