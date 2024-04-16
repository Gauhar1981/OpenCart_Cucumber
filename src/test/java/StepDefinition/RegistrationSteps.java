package StepDefinition;
	
	import java.time.Duration;
import java.util.Map;

	import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.BaseClass;
	import io.cucumber.datatable.DataTable;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	import PageObjects.AccountRegistration;
import PageObjects.BasePage;
import PageObjects.HomePage;
	import PageObjects.LoginPage;


	public class RegistrationSteps {
		
		WebDriver driver;
		
		HomePage hp;
	     LoginPage lp;
	     AccountRegistration regpage;
	     
		@Given("the user navigates to Register Account page")
		public void user_navigates_to_register_account_page() {
			
			BaseClass.getLogs().info("******Executing User Registration scenario*****");
		
			BaseClass.getLogs().info("Go to My Account menu --> click Register");
			hp=new HomePage(BaseClass.getDriver());
			
	    	hp.clickMyAccount();
	        hp.ClickRegister();
	                   
		}

		@When("the user enters the details into below fields")
		public void user_enters_the_details_into_below_fields(DataTable dataTable)
		{
			BaseClass.getLogs().info("Entering user details");
			Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		    
			regpage=new AccountRegistration(BaseClass.getDriver());
			regpage.SetFirstName(dataMap.get("firstName"));
			regpage.SetLastName(dataMap.get("lastName"));
			regpage.SetEmail(BaseClass.randomAlphaNumeric()+"@gmail.com");
			
			regpage.SetPassword(dataMap.get("password"));			
		}

		@When("the user selects Privacy Policy")
		public void user_selects_privacy_policy() {
			
			regpage.setPrivacyPolicy();
			BaseClass.getLogs().info("selected Privacy Policy .....");
		}
		

		@When("the user clicks on Continue button")
		public void user_clicks_on_continue_button() throws InterruptedException {
			BaseClass.getLogs().info("Clicking on Continue button.....");
			regpage.clickContinue();
			
			BaseClass.getLogs().info("Clicked Continue button.....");
			Thread.sleep(2000);
			
		}

		@Then("the user account should get created successfully")
		public void user_account_should_get_created_successfully() 
		{
						
			String confmsg=regpage.getConfirmationMessage();
			BaseClass.getLogs().info("Validation confirmation message.....");
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
			BaseClass.getLogs().info("Validation successful ....");
			BaseClass.getLogs().info("***Registration Scenario is passed");
		}
		
	 }



