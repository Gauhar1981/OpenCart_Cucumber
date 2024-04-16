package factory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	
	static public WebDriver driver;
	static Logger logger;
	static Properties p;
	
	
    @SuppressWarnings("deprecation")
	public static WebDriver initializeBrowser() throws IOException 
    {
    	if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote"))
	 	{	
		
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
		//os
		if(getProperties().getProperty("os").equalsIgnoreCase("windows"))
		{
			capabilities.setPlatform(Platform.WIN10);
		}
		else if(getProperties().getProperty("os").equalsIgnoreCase("mac"))
		{
			capabilities.setPlatform(Platform.MAC);
		}
		else
		{
			System.out.println("No matching os..");
			
		}
		
		//browser
		switch(getProperties().getProperty("browser").toLowerCase())
		{
		case "chrome" : 
			capabilities.setBrowserName("chrome"); 
			break;
		case "edge" : 
			capabilities.setBrowserName("MicrosoftEdge");
			break;
		default: 
			System.out.println("No matching browser..");
			
		}
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);	
		
	    }
    	
    	else if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
		{
			//launching browser based on condition - locally
			switch(getProperties().getProperty("browser").toLowerCase())
			{
			case "chrome": 
				driver=new ChromeDriver(); 
				break;
			case "edge": 
				driver=new EdgeDriver(); 
				break;
			default: 
				System.out.println("No matching browser..");
				driver=null;
			}
		}
    	driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		
		return driver;
    	
    }
    
    public static WebDriver getDriver()
    {
    	
		return driver;
    	
    }
    
    public static Properties getProperties() throws IOException
    {
    	//loading properties file
		 FileReader file=new FileReader(".//src//test//resources//config.properties");
		 p=new Properties();
		 p.load(file);
		return p;
		
    }
    
    public static Logger getLogs()
    {
		//loading log4j 
		logger=LogManager.getLogger();//Log4j
		return logger;
    }
    
	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	public static String randomAlphaNumeric()
		{
		String str=RandomStringUtils.randomAlphabetic(5);
		 String num=RandomStringUtils.randomNumeric(10);
		return str+num;
		}
	

}
