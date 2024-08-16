package TecharkTest.Finpress.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TecharkTest.Finpress.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	//private static final AddCustomer AddCustomer = null;

	public static WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		LandingPage.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(css="[class ='green-btn']")
	WebElement loginbutton;
	
	
	public void loginApplication(String email, String pass)
	{
		username.sendKeys(email);
		password.sendKeys(pass);
		loginbutton.click();
	}
	
	public static void goTo()
	{
	driver.get("https://www.finpress-testing.tekark.com/site-admin/login");
	}

	public ManageCustomer createCustomer(String customer, String urlTitle, String logo) throws InterruptedException 
	{
	   	AddCustomer addcust = new AddCustomer(driver);
	   	addcust.customerAdd(customer, urlTitle, logo);
	   		   	
		return null;
		
	
		
	}
	
	
	
	
}
