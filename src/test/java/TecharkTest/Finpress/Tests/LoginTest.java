package TecharkTest.Finpress.Tests;

import java.awt.AWTException;
import java.io.IOException;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import TecharkTest.Finpress.TestComponents.BaseTest;
import TecharkTest.Finpress.pageObjects.LandingPage;
import TecharkTest.Finpress.pageObjects.ManageCustomer;

public class LoginTest extends BaseTest{

	@Test
	
	public void RegressionTest() throws IOException, InterruptedException, AWTException 
	{
		LandingPage landingPage = launchApplication();
		
		landingPage.loginApplication("agarodia.techark@gmail.com","Admin@123");
		
		landingPage.createCustomer("NewCustomer12Aug","google128","C:/Users/pc/Desktop/QA_Common_Files/Sample Files for Upload/file sample.jpg");
		
		String custTitle = "google128";
		
		Thread.sleep(2000);
		
	    ManageCustomer manageCustomer = new ManageCustomer(driver);
		
		Boolean match = manageCustomer.VerifyTitleDisplay(custTitle);
	
		Assert.assertTrue(match);
		
		Thread.sleep(3000);
		   
	    WebElement editLink = driver.findElement(By.cssSelector("a.moduleActions[href*='/site-admin/customer/edit/']"));

	        // Click on the Edit link
	    editLink.click();
	    
	        Thread.sleep(2000);
	       
	        //Removing old values and adding new values on the edit page
	   
	    WebElement editTitle = driver.findElement(By.xpath("//input[@id='title']"));
	  	   
	    editTitle.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	    
	    editTitle.sendKeys("Newtitle12thAug7");
	 
	   WebElement editUrl = driver.findElement(By.xpath("//input[@id='url']"));

	String currentUrl = editUrl.getText();

	System.out.println(currentUrl);

	Thread.sleep(2000);
	
	editUrl.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	   
	editUrl.sendKeys("NewUrl12thAug7");

	Thread.sleep(3000); 

	//Saving the updated changes on the edit page
	driver.findElement(By.xpath("//button[@class='green-btn']")).click();

	Thread.sleep(3000);

	//Navigating to the Manage Customers grid view again
	driver.findElement(By.xpath("//a[@href = '/site-admin/customers']")).click();

	Thread.sleep(3000);
	//Clicking ont the Delete Action button
	WebElement deleteLink = driver.findElement(By.xpath("//a[@class='moduleActions'][2]"));

	deleteLink.click();

	Thread.sleep(6000);

	//Clicking the 'Yes delete' option of the delete confirmation pop-up
	driver.findElement(By.xpath("//div //button[@class='swal2-confirm swal2-styled']")).click();

	Thread.sleep(7000);

	//Create new job

	driver.findElement(By.xpath("//a[@class='green-btn create_job']")).click();

	Thread.sleep(3000);

	WebElement jobTitle1 = driver.findElement(By.xpath("//input[@id='title']"));
	jobTitle1.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	String jobTitleNew = "New Job 12th Aug 7";
	jobTitle1.sendKeys(jobTitleNew);

	WebElement jobUrl = driver.findElement(By.xpath("//input[@id='slug']"));
	jobUrl.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	jobUrl.sendKeys("Job New Url 12th Aug 7");

	driver.findElement(By.xpath("//label[@class='custom-control-label' and @for='negotiating']")).click();

	WebElement jobDisplayTitle = driver.findElement(By.xpath("//input[@id='display_title']"));
	jobDisplayTitle.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	String jobDisplayTitleText = "New Job Title Display 12th Aug 7";
	jobDisplayTitle.sendKeys(jobDisplayTitleText);

	Select jobStatus1 = new Select(driver.findElement(By.name("status")));
	jobStatus1.selectByIndex(1);

	Thread.sleep(2000);
	driver.findElement(By.xpath("//label[@class='custom-control-label' and @for='fos_disclaimer']")).click();

	Thread.sleep(2000);
		
	driver.findElement(By.xpath("//input[@id='amount']")).sendKeys("1000");

	driver.findElement(By.xpath("//input[@id='bond_counsel']")).sendKeys("Testing");

	driver.findElement(By.xpath("//div//input[@id='lead_manager']")).sendKeys("Testing Manager");

	driver.findElement(By.xpath("//div//input[@id='buyer']")).sendKeys("Testing Buyer");

	Select jobState = new Select(driver.findElement(By.name("state")));
	jobState.selectByIndex(2);

	driver.findElement(By.xpath("//label[@class='custom-control-label' and @for='SendGrid']")).click();

	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//button[@class='tox-tbtn' and @title='More...'][1]")).click();
	
	driver.findElement(By.xpath("(//div[@role='toolbar'] //button[@title='Source code'and @aria-label='Source code'])")).click();
	
	driver.findElement(By.xpath("//textarea[@class='tox-textarea']")).sendKeys("This is for testing");
	
	driver.findElement(By.xpath("//div[@role='presentation'] //button[@class='tox-button' and @title='Save']")).click();
	
	Thread.sleep(2000);
				
	//String filePath = "C:\\Users\\pc\\eclipse-workspace\\Maven\\Finpress\\src\\main\\java\\TecharkTest\\Finpress\\Resources\\file sample.jpg";
	
	WebElement file = driver.findElement(By.xpath("//div[@class='file-selector']//button[@class='green-btn']"));
	
	file.sendKeys("C:/Users/pc/Desktop/QA_Common_Files/Sample Files for Upload/file sample.jpg");
	
	//driver.switchTo().activeElement();
	//driver.findElement(By.xpath("//button[@type='button' and @class='green-btn']")).sendKeys(filePath);
	
	//driver.sendKeys("C:/Users/pc/Desktop/QA_Common_Files/Sample Files for Upload/file sample.jpg");
	
	//driver.switchTo().window(jobDisplayTitleText);
	
	Thread.sleep(2000);
		
	
	driver.findElement(By.xpath("//button[@type='submit'and @class='green-btn']")).click();
   
	Thread.sleep(2000);
	
	//driver.close();
	  
}
	}
