package roughWork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;

public class ReadingExcelData {

	
/** 
 * in order to read excel file we need: 
 * 
 * excel file --> workbook --> sheets --> rows --> cells
 * @throws IOException 
 *  
 */
	
	public static void main (String[] args) throws IOException {
		
//import file
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/testData/data.xlsx");
	
		
//import workbook		
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis); 
		
		
//add sheet
		
	//	XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		
		
//count rows 
		
		int totalRows = sheet.getLastRowNum();
		
		System.out.println("Total rows: " + totalRows);

	
//count cells
		
		int totalCells = sheet.getRow(0).getLastCellNum();
		
		System.out.println("Total cells: " + totalCells);
		
		
		
//create a for loop, outer loop and nested loop
		
		for (int r = 0; r <= totalRows; r++) {
			
			XSSFRow activeRow = sheet.getRow(r);
			
			for (int c = 0; c < totalCells; c++ ) {
				
				XSSFCell currentCell = activeRow.getCell(c); 
				
				
				//System.out.println(currentCell.toString()); //print statement, we can update it. remove ln and print
				
				System.out.print(currentCell.toString() + "   ");
				
			}
			
			
			System.out.println();
			
			
			
		} //end of for loops

		
		
//close workbook and file. 
		
		workbook.close();
		fis.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//end of main method
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
