package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
//constructor
	
	public LoginPage(WebDriver driver) {
		super(driver); //create super class constructor 
		
	}
	
 
	
//locator
	
	
	@FindBy (xpath="//input[@name='email']")
	
		WebElement txtEmail;
	
	
	
	@FindBy (xpath="//input[@name='password']")
	
		WebElement txtPassword;
	
	
	
	@FindBy (xpath="//input[@value='Login']")
	
		WebElement btnLogin;
	
	
	
	
	
	
//action methods
	
	
	public void setEmail (String email) {
		
		txtEmail.sendKeys(email);
		
	}
	
	
	
	public void setPassword (String pwd) {
		
		txtPassword.sendKeys(pwd);
		
	}
	
	
	
	public void clickLogin () {
		
		btnLogin.click();
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
