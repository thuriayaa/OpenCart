package utilities;

import java.io.IOException;

import org.testng.annotations.*;

public class DataProviders {
	
	
//how do you mention that this is a data provider method... use testng @dataprovider annotation 
	
	@DataProvider (name = "LoginData")
	
	public String[][] getData () throws IOException {
		
		
//create file path
		
	String path = "./testData/LoginData.xlsx"; 
	
	
//create object of ExcelUtility class //b/c it has a constructor, it is asking for a path variable. 
	
	ExcelUtility xlutility = new ExcelUtility(path); 
	
	
	int totalrows = xlutility.getRowCount("Sheet1"); 
	
	int totalcols = xlutility.getCellCount("Sheet1", 1);
	
	
//login data saved as 2D array - this is declaring 2D array. 
		
		/**
		 
		int name [] [] = new int [2][6]; how to declare an array with int data type, add size
		
		*/
	
	String logindata [][] = new String [totalrows][totalcols]; //pass the arrow size
	
	
//use nested for loop
	
	for (int i = 1; i <= totalrows; i++) {
		
		for (int j=0; j < totalcols; j++ ) {
			
			logindata[i - 1][j] = xlutility.getCellData("Sheet1", i, j);
			
		}
		
	} //nested loop closed
	

	return logindata;
	

		
	}//method getdata closed
	
	
//we can have multiple data provider annotation in one class. follow same technique to create the data provider 
	
	
	
	

} //class closed
