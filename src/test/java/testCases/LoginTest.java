package testCases;

import testBase.BaseClass;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class LoginTest extends BaseClass {
	
	
	@Test  (groups = {"Regression", "Master"}) //multiple group names at once { "" , "" }
	public void validateLogin () {
		

logger.info("~~~~~~~~~~~~~~~~ Starting Login Test ~~~~~~~~~~~~~~~~");
		
logger.debug("############# Capturing application debug logs #############");
		
		

		try { //try catch starts here
			
			
		
/**
 * create object of homepage ... cannot create an object outside of a method...
 *  at class level we cannot object of a class. java does not allow it
 */
		
		HomePage homePage = new HomePage(driver); 
		
			homePage.clickOnMyAccount();
			
			homePage.clickOnLogin();
			
		
logger.info("----- clicked on login link under my account ---------");
		
		
		
//create an object of login page
		
		LoginPage loginPage = new LoginPage (driver);
		
		
logger.info("----- adding login credentials ---------");

		
			loginPage.setEmail(prop.getProperty("email")); //keys and values are also string, needs to be in ""
			
			loginPage.setPassword(prop.getProperty("password"));
			
			loginPage.clickLogin();
		
			
logger.info("----- clicked on login button to access my account ---------");
			
			
			
//create an object of myaccount page

	
		MyAccountPage myAccount = new MyAccountPage (driver);
		
			boolean displayStatusMyAccountPage = myAccount.isMyAccountPageExists();
	
			
//create an assert - hard. 
			
			Assert.assertEquals(displayStatusMyAccountPage, true, "Login Failed");
			
			
			
		} catch (Exception e) {
			
			Assert.fail();
			
			
		} finally {
			

logger.info("----- login test completed. Alhamdulillah ---------");

			
			
		} // try catch closing 
			
		
		
	} //closing method 
	

	
	//cannot run this test here b/c in base class, we have a switchpage ... 
	
	
	/**
	 * what is the difference between final and finally? 
	 * 
	 * finally is a optional block - try - tries and success, if any part of the try fails, catch blocks starts, find that exception
	 * 
	 *  ... finally: pass or fail, it always gets executed 
	 *  
	 *  keyword final is something used to express if you declare a final variable,
	 *  whatever you assigned to that variable, that value is final
	 *  and cannot change. 
	 *  
	 *  
	 *  data driven test is test is done through data. if the test data change, the test change... 
	 *  based on valid and invalid data entry, test fail or pass
	 *  
	 * 
	 */
	

}
