package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import org.testng.annotations.Parameters;

public class BaseClass {
	
	
	public static WebDriver driver;
	

	public Logger logger; //declare logger interface, declare the object 
	
	
	public Properties prop;
	
	
	
//setup() -  
		
		
		@BeforeClass (groups = {"Regression", "Master", "Sanity", "Ddt"})
		
		@Parameters ({"OS", "browser"}) //sequence as in testng xml file and the case sensitive, write as in xml file
	
		public void setup( String os, String br) throws IOException {
			
			
//loading properties files
			
			FileReader file = new FileReader("./src/test/resources/config.properties");
			
			prop = new Properties();
			
			prop.load(file);
			
			
			
			
			
			
			logger = LogManager.getLogger(this.getClass()); //object of logger class
			
			
//switch statement - now run through testng xml file
			
		switch (br.toLowerCase()) {
			
			case "chrome" : driver = new ChromeDriver(); 
			
				break;
			
			
			case "firefox" : driver = new FirefoxDriver(); 
			
				break;
			
			
			case "edge" : driver = new EdgeDriver(); 
			
				break;
				
			
			default : System.out.println("This browser is not supported");
			
				return;
			
		}
			
		
			
			//driver = new ChromeDriver();
			
			driver.manage().deleteAllCookies(); 
			
			/**
			 * cookies are some information, used by all apps to give better user experiences but actually collects user informations. 
			 * cookies are saved inside the browser locally
			 */
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
			
			logger.info("**************** Launching Application ****************");
			
			
			//driver.get("https://tutorialsninja.com/demo/");
			
			
			driver.get(prop.getProperty("appURL")); //replaced the url with this configuration 
			
			
		}
		
	
	
	
	
//tearDown()
		
		
		@AfterClass (groups = {"Regression", "Master", "Sanity", "Ddt"})
		public void tearDown () {
			
			driver.quit();
			
		}
		
		
		
//random string and numbers code sections
		
		public String randomString() {
			
			/* 
			 * method 1: 
			 * 
			 * String generatedString = RandomStringUtils.randomAlphabetic(5);
			 * return generatedString;
			 */
			
			
			// method 2
			
			return RandomStringUtils.randomAlphabetic(5);
			
			
		}
		
		
		
		public String randomNumbers() {
			
			return RandomStringUtils.randomNumeric(10); //create random numbers for telephone
		}
		
		
		
		public String randomAlphaNumeric() {
			
			String str = RandomStringUtils.randomAlphabetic(3);
			
			String num = RandomStringUtils.randomNumeric(3);
			
			return (str + "%" + num);
		}
		
		
//screenshot capturing method, we need to use an interface: TakesScreenshot
		
		public String captureScreetshot(String name) {
			
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			
			
			//TakesScreenshot takeScreenshot = (TakesScreenshot) driver; //type cast TakesScreenshot in this way with driver. 
			
			
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); //made to one line instead of two line of codes
			
			
			String targetFilePath = System.getProperty("user.dir") + "/screenshots/" + name + "_" + timeStamp + ".png"; //target file path
			
			
			File targetFile = new File(targetFilePath);
			
			
			src.renameTo(targetFile); 
			
			
			return targetFilePath;
			
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
