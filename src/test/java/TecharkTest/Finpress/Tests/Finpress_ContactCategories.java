 package TecharkTest.Finpress.Tests;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import TecharkTest.Finpress.TestComponents.BaseTest;
import TecharkTest.Finpress.pageObjects.LandingPage;

public class Finpress_ContactCategories extends BaseTest{
@Test
	
	public void ManageCategoriesTest() throws InterruptedException, IOException {	
		
        LandingPage landingPage = launchApplication();
		
		landingPage.loginApplication("agarodia.techark@gmail.com","Admin@123");
		
		Thread.sleep(4000);

		//Clicking on the Contact Categories on the Dashboard

		driver.findElement(By.xpath("//a[@href='/site-admin/contactcategories' and @class='stretched-link green-btn']")).click();

		Thread.sleep(4000);

		//Creating new category

		driver.findElement(By.xpath("//a[@href='/site-admin/contactcategory/create' and @class='green-btn']")).click();

		driver.findElement(By.xpath("//input[@id='category_name']")).sendKeys("Test 38");

		Thread.sleep(2000);

		WebElement file = driver.findElement(By.xpath("//input[@id='file']"));

		file.sendKeys("C:\\Users\\pc\\Desktop\\QA_Common_Files\\Testing\\Testing.csv");

		Thread.sleep(2000);

		//Saving the created category
		WebElement saveButton = driver.findElement(By.xpath("//button[@class='green-btn' and @type='submit']"));
		saveButton.click();

		//Validate if created category is found in the list of categories

		String titlenew = "Test 38";

		List<WebElement> categoryList = driver.findElements(By.xpath("//tr //td [1]"));

		categoryList.stream().anyMatch(titlecheck->titlecheck.getText().equalsIgnoreCase(titlenew));

		System.out.println("Created category found");
		//Edit the created category
		Thread.sleep(5000);
		WebElement editCategoryLink = driver.findElement(By.xpath("//i[@class='fa fa-pencil']"));

		    // Click on the Edit link
		editCategoryLink.click();

		    Thread.sleep(2000);
		   
		    //Removing old values and adding new values on the edit category page
		WebElement editCategory = driver.findElement(By.xpath("//input[@id='category_name']"));

		editCategory.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));

		editCategory.sendKeys("Test 39");
		//Updating the created category
		WebElement updateButton = driver.findElement(By.xpath("//button[@class='green-btn' and @type='submit']"));
		updateButton.click();
		Thread.sleep(4000);
		//Clicking on the Delete Action button
		WebElement deleteLink = driver.findElement(By.xpath("//i[@class='fa fa-trash']"));

		deleteLink.click();

		Thread.sleep(6000);

		//Clicking the 'Yes delete' option of the delete confirmation pop-up
		driver.findElement(By.xpath("//div //button[@class='swal2-confirm swal2-styled']")).click();

		Thread.sleep(7000);
}



}
