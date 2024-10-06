package testCases;

import org.testng.Assert;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

import org.testng.annotations.*;

public class LoginDDT extends BaseClass {
	
//login data driven testing 
	
//create test method
	
	
	
	
	@Test (dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "Ddt" )
	public void validate_loginDDT (String email, String password, String dataType) {
		
		 

			logger.info("~~~~~~~~~~~~~~~~ Starting Login Test ~~~~~~~~~~~~~~~~");
					
			logger.debug("############# Capturing application debug logs #############");
					
	
	
	try {

			/**
			 * create object of homepage ... cannot create an object outside of a method...
			 *  at class level we cannot object of a class. java does not allow it
			 */
				//homepage 
						
					HomePage homePage = new HomePage(driver); 
					
						homePage.clickOnMyAccount();
						
						homePage.clickOnLogin();					
					 
						
				//loginpage - create an object of login page
						
					LoginPage loginPage = new LoginPage (driver);
					  
					
						loginPage.setEmail(email); //keys and values are also string, needs to be in ""
						
						loginPage.setPassword(password);
						
						loginPage.clickLogin();
					  
						
				//myAccountpage - create an object of myaccount page
						
					MyAccountPage myAcctPage = new MyAccountPage (driver);
					
						boolean targetpage = myAcctPage.isMyAccountPageExists();
				
						 
				//add logic  - if login pass, then logout, test pass. 
						
						if (dataType.equalsIgnoreCase("valid")) {
							
							if (targetpage == true) {
								myAcctPage.clickOnLogout();
								
								Assert.assertTrue(true);  
								
							} else {
								
								Assert.assertTrue(false);
							}
							
						}//if closed
		
						
				//handle invalid data - logic
						
						if (dataType.equalsIgnoreCase("Invalid")) {
							
							if (targetpage == true) {
								
								myAcctPage.clickOnLogout();
								
								Assert.fail();
								
							} else {
								
								Assert.assertTrue(true);
							}
							
						} //if closed
						
						
	} //try close to start catch  
	
	catch (Exception e) {
		
		Assert.fail("An exception occured" + e.getMessage()); //if any part of the test fails, total test is failed 
		
		
	} //catch closed to start finally block 
	
	finally {
		
		logger.info("********************* LoginDDT is finished ****************************");
		
		
	} //finally closed . try catch finally is closed completely. 
						
		
		
	
	
	
	
	
	}//method closed
	
	
	
	

}//class closed
