package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass; //important the BaseClass from the testBase package

public class AccountRegistrationTest extends BaseClass {


	
	
	
	
//validateRegistration() -  
	
	@Test (groups = {"Sanity", "Master"}) //multiple group names at once { "" , "" }
	public void validateAccountRegistration () {
		
		
logger.info("**************** Starting the Account Registration Test ****************");

logger.debug("-------------------- This is a Debug Log Message --------------------");
		
		


		try {
			
			
		
		HomePage homePage = new HomePage(driver); //object of HomePage class 
		
		
logger.info("**************** clicking on my account ****************");

		
		homePage.clickOnMyAccount();
		
		homePage.clickOnRegister();
		
		
logger.info("**************** clicked on registration link ****************");

		
		RegistrationPage regPage = new RegistrationPage(driver); //create object of RegistrationPage class 
		
		
logger.info("**************** providing customer info to sign up account ****************");

		
		regPage.setFirstName(randomString().toUpperCase());
		
		regPage.setLastName(randomString().toUpperCase());
		
		
		regPage.setEmail(randomString() + "@gmail.com");
		
		regPage.setTelephone(randomNumbers());
		
		
		String pwd = randomAlphaNumeric();
		
			regPage.setPassword(pwd);
			
			regPage.setConfirmPassword(pwd);
			
		
		regPage.setPrivacyPolicy();
		
		regPage.clickContinue();
		
		
logger.info("**************** validating expected message ****************");

		 
		String confmsg = regPage.getConfirmationMsg(); //return type is string, 
		
			AssertJUnit.assertEquals(confmsg, "Your Account Has Been Created!"); //hard assertion. 
		 
		
logger.info("****************  account registrtion passed ****************");

			 

		} catch (Exception e) {
			
		} finally {
			
		
logger.info("************** Finished account registration *************");


		}
				
				

		
		}
	 
	 
	
	
	
	
	
	
	
	
	
	

}
