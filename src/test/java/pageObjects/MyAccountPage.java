package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyAccountPage extends BasePage {


//constructor
		
	public MyAccountPage(WebDriver driver) {
		super(driver);
		 
	}

	 
	
//locators
	
	
	@FindBy (xpath = "//h2[text()='My Account']") 
	
		WebElement msgHeading; 
	 


	@FindBy (xpath = "//div[@class='list-group']//a[text()='Logout']")
	
		WebElement link_logout;
	
	
	
//action methods
	
	
	public boolean isMyAccountPageExists () {
		
		try {
		
		return	msgHeading.isDisplayed();
		
		} catch (Exception e) {
			
			return (false);
			
		}//try cath closed
		 
	} //closed method
	
	
	
	public void clickOnLogout () {
		
		link_logout.click();
		
	} //method closed
	
	
	
	
	
	
	
}
