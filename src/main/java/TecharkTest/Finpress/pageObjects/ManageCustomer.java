package TecharkTest.Finpress.pageObjects;

import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TecharkTest.Finpress.AbstractComponents.AbstractComponents;

public class ManageCustomer extends AbstractComponents{

	WebDriver driver;
	
	public ManageCustomer(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//tr //td [3]")
	public List<WebElement> customerList;
	

	public Boolean VerifyTitleDisplay(String urlTitle) {
		Boolean match = customerList.stream().anyMatch(title -> title.getText().equalsIgnoreCase(urlTitle));
		
		System.out.println("Created customer found");
		
		return match;
	}
	
		
}
