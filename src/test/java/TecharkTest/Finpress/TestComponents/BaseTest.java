package TecharkTest.Finpress.TestComponents;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import TecharkTest.Finpress.pageObjects.LandingPage;

public class BaseTest {
	public static WebDriver driver;
	public static WebDriver initializeDriver() throws IOException
	{
   	     // Initialize ChromeDriver
		
	    WebDriver driver = new ChromeDriver();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;
	}
	
	public static LandingPage launchApplication() throws IOException, InterruptedException
	{
		 driver = initializeDriver();
		 Thread.sleep(3000);			 
		 LandingPage landingPage = new LandingPage(driver);
	     LandingPage.goTo();
	     return landingPage;
	}
	
	

}
