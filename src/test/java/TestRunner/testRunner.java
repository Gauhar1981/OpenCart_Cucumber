package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		          //features= {".//Features/"},
		           //features= {".//Features/Login.feature"},
		          //features= {".//Features/Registration.feature"},
		          //features={".//Features/LoginDDT_Excel.feature"},
		          features= {".//Features/Login.feature",".//Features/Registration.feature"},
		          //features= {"@target/rerun.txt"},  
		          glue="StepDefinition",
		          plugin= {"pretty","html:Reports/myreport.html","rerun:target/rerun.txt",
		        		   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		                  },
		          
		         dryRun=false,   //checks mapping between scenario steps and step definition methods
		         monochrome=true,  // to avoid junk character in output
		         publish=true,
		         //tags="@Sanity"  //this will execute scenarios tagged with @Sanity
		         //tags="@Sanity and @Regression"  //execute scenarios tagged with both @sanity and @regression
		         ////tags="@Sanity and not @Regression"    //scenarios tagged with @Sanity but not tagged with @Regression
		         tags="@Sanity or @Regression"  //Scenarios tagged with either @Sanity or @Regression.
		         
		        )
public class testRunner {
	
	

}
