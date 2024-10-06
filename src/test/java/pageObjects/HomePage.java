package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class HomePage extends BasePage { //call the constructor of the superclass, 
	
	//WebDriver driver;
	
	
//create constructor 
	
	public HomePage (WebDriver driver) {
		
		super(driver);
	
	}
	
	
	
	
//locators  //on links, perform click operations 
	
	@FindBy(xpath="//*[@title='My Account']") 
	
	WebElement link_myAccount; 
	
	
	
	
	@FindBy(xpath="//a[text()='Register']")
	
	WebElement link_register;
	
	
	
	
	@FindBy (xpath="//a[text()='Login']")
	
	WebElement link_login;
	
	
	
//action methods
	
	public void clickOnMyAccount() {
		
		link_myAccount.click();
		
	}
	
	
	
	public void clickOnRegister() {
		
		link_register.click();
		
	}
	
	
	
	
	public void clickOnLogin () {
		
		link_login.click();
	}
	
	
	
	
	

}
