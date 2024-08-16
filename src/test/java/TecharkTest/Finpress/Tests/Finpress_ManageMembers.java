package TecharkTest.Finpress.Tests;
import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import TecharkTest.Finpress.TestComponents.BaseTest;
import TecharkTest.Finpress.pageObjects.LandingPage;

public class Finpress_ManageMembers extends BaseTest{

	@Test
	
	public void ManagemembersTest() throws InterruptedException, IOException {	
		
        LandingPage landingPage = launchApplication();
		
		landingPage.loginApplication("agarodia.techark@gmail.com","Admin@123");
		
		Thread.sleep(4000);

		//Clicking on the Members module on the Dashboard

		driver.findElement(By.xpath("//a[@href='/site-admin/users' and @class='stretched-link green-btn']")).click();

		Thread.sleep(4000);

		//Creating new member

		driver.findElement(By.xpath("//a[@href='/site-admin/user/create' and @class='green-btn']")).click();

		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Taksheel");

		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Agrawal6");

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("taksheelag6@gmail.com");

		String val = "7798786876"; 
		WebElement phone = driver.findElement(By.xpath("//input[@id='phone']"));
		phone.clear();

		for (int i = 0; i < val.length(); i++){
		    char c = val.charAt(i);
		    String s = new StringBuilder().append(c).toString();
		    phone.sendKeys(s);
		}       

		Select group = new Select(driver.findElement(By.name("role")));
		group.selectByIndex(1);

		Select status = new Select(driver.findElement(By.name("status")));
		status.selectByIndex(1);

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");

		driver.findElement(By.xpath("//input[@id='confirm_password']")).sendKeys("password");

		driver.findElement(By.xpath("//button[@class='green-btn' and @type='submit']")).click();

		//Validate if created member is found in the list of members
		String fullName = "Taksheel Agrawal6";

		List<WebElement> memberList = driver.findElements(By.xpath("//tr //td [2]"));

		memberList.stream().anyMatch(titlecheck->titlecheck.getText().equalsIgnoreCase(fullName));

		System.out.println("Created member found");

		//Edit the created member

		Thread.sleep(5000);

		WebElement editLink = driver.findElement(By.cssSelector("a.moduleActions[href*='/site-admin/user/edit/']"));

		// Click on the Edit link
		editLink.click();

		Thread.sleep(2000);
		//Removing old values and adding new values on the edit page

		WebElement editFirstName = driver.findElement(By.xpath("//input[@id='first_name']"));

		String currentFirstName = editFirstName.getText();

		System.out.println(currentFirstName);

		editFirstName.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));

		editFirstName.sendKeys("Taksheel7");

		WebElement editEmail = driver.findElement(By.xpath("//input[@id='email']"));

		String currentEmail = editEmail.getText();

		System.out.println(currentEmail);

		Thread.sleep(2000);

		editEmail.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));


		editEmail.sendKeys("taksheelag7@gmail.com");

		Thread.sleep(3000); 

		//Saving the updated changes on the edit page
		driver.findElement(By.xpath("//button[@class='green-btn']")).click();

		Thread.sleep(3000);

		//Navigating to the Manage Members grid view again
		driver.findElement(By.xpath("//a[@href = '/site-admin/users']")).click();

		Thread.sleep(3000);
		//Clicking on the Delete Action button
		WebElement deleteLink = driver.findElement(By.xpath("//a[@class='moduleActions'][2]"));

		deleteLink.click();

		Thread.sleep(6000);

		//Clicking the 'Yes delete' option of the delete confirmation pop-up
		driver.findElement(By.xpath("//div //button[@class='swal2-confirm swal2-styled']")).click();

		Thread.sleep(7000);

		driver.close();

		}

		}



