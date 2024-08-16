package TecharkTest.Finpress.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import TecharkTest.Finpress.AbstractComponents.AbstractComponents;

public class AddCustomer extends AbstractComponents{
public static WebDriver driver;
	
	public AddCustomer(WebDriver driver)
	{
		super(driver);
		LandingPage.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	
		@FindBy(xpath = "//a[@href = '/site-admin/customers']")
		WebElement customers;
		
		@FindBy(xpath = "//a[@href = '/site-admin/customer/create']")
		WebElement customercreate;
		
		@FindBy(id= "title")
		WebElement title1;
		
		@FindBy(id= "url")
		WebElement url;
		
		@FindBy(id= "file")
		WebElement logo;
	
		 @FindBy(xpath = "//select[@id='role']")
		 WebElement dropdownElement;
		 
		 @FindBy(xpath = "//button[@class='green-btn']")
		 WebElement saveButton;
		
	public String customerAdd(String customer, String urlTitle, String logo1) throws InterruptedException
    {
			customers.click();
			Thread.sleep(2000);
			customercreate.click();
			title1.sendKeys(customer);
			url.sendKeys(urlTitle);
		    logo.sendKeys(logo1);
		    
		    Thread.sleep(2000);
		    
		    Select dropdown = new Select(dropdownElement);
	        dropdown.selectByVisibleText("Active");
         
	        Thread.sleep(2000);
	        
	        saveButton.click();
	        
	        //String url = title1.getText();
	        
	        	    
		    Thread.sleep(2000);
			
		    return customer;
		}

     }
