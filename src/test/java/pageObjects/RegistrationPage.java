package pageObjects;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RegistrationPage extends BasePage {
	
	//WebDriver driver; 
	
//constructor
	
	public RegistrationPage (WebDriver driver) {
		
		super(driver);
		
	}
	
	

	
//locators
	
	@FindBy (xpath="//input[@name='firstname']") //any text field will have txt at the beginning 
	
	WebElement txtFirstname; 
	
	
	
	@FindBy (xpath="//input[@name='lastname']")
	
	WebElement txtLastname;
	
	
	
	@FindBy (xpath="//input[@name='email']")
	
	WebElement txtEmail;
	
	
	
	@FindBy (xpath="//input[@name='telephone']")
		
		WebElement txtTelephone;
	
	
	
	
	@FindBy (xpath="//input[@name='password']")
	
		WebElement txtPassword;
	
	
	
	@FindBy (xpath="//input[@name='confirm']")
	
		WebElement txtConfirmPassword;
	
	
	
	@FindBy (xpath="//input[@type='checkbox']")
	
		WebElement chkboxPrivacy;	
	
	
	
	@FindBy (xpath="//input[@value='Continue']")
	
		WebElement btnContinue;	
	
	
	
	@FindBy (xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	
		WebElement msgConfirmation;
	
	
	
//action methods
	
	
	public void setFirstName (String fname) {
		
		txtFirstname.sendKeys(fname);
	}
	
	
	
	public void setLastName (String lname) {
			
		txtLastname.sendKeys(lname);
		}


	public void setEmail (String email) {
		
		txtEmail.sendKeys(email);
	}


	
	public void setTelephone (String tel) {
		
		txtTelephone.sendKeys(tel);
	}


	
	public void setPassword (String pwd) {
		
		txtPassword.sendKeys(pwd);
	}
	
	
	
	public void setConfirmPassword (String pwd) {
			
		txtConfirmPassword.sendKeys(pwd);
		}

	
	
	public void setPrivacyPolicy() {
		
		chkboxPrivacy.click();
	}
	
	
	
	public void clickContinue () {
		
		//option 1
		
		btnContinue.click();
		
		
	
		
		
		
		
		
		
		
		
		/** different methods to click
		 
		option 2:  
		
		btnContinue.submit();
		
		
		
		option 3: create object of action class
		
		Actions act = new Actions(driver);
		
			act.moveToElement(btnContinue).click().perform();
		
		
		
		option 4: with java script - it is an interface. 
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
			js.executeScript("arguments[0].click();", btnContinue);
		
		
		
		option 5: could click using sendkeys though not done usually, interview question
		
		btnContinue.sendKeys(Keys.RETURN);
		
		
				
		option 6: apply explicit wait to make sure web action are not interrupted 
	
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
			mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		
		*/
		
	}
	
	
	
	public String getConfirmationMsg() {
		
		try { //must have return in both try and catch blocks or will throw errors and stop running codes. 
			
			return 	msgConfirmation.getText();
		
		} catch (Exception e ) {
			
			return e.getMessage();
		}
		
	}
	

}
