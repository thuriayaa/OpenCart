package utilities;

import java.io.*;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtility {

//file name first 
	public FileInputStream fi; 
	
	public FileOutputStream fo; 
	
//workbook name 2nd
	
	public XSSFWorkbook workbook;
	
//sheet 3rd
	
	public XSSFSheet sheet;
	
//row
	
	public XSSFRow row;
	
//cell
	
	public XSSFCell cell;
	
//path
	
	String path;
	
	
//create a constructor public + classname
	
	public ExcelUtility (String path) {
		
		this.path = path; //refer to the variable //constructor is now done. 
		
	}
	
	
//inside a sheet, what need to find? row number  - use java to count rows  - universal method to get rows from an excel sheet. 
	
	public int getRowCount(String sheetName) throws IOException {
		
		fi = new FileInputStream(path);
		
		workbook = new XSSFWorkbook(fi);
		
		sheet = workbook.getSheet(sheetName);
		
		int rowCount = sheet.getLastRowNum();
		
		workbook.close();
		
		fi.close();
		
		return rowCount;
		
	}
	
	
//we can count the cells now... another method for cell count
	
	public int getCellCount(String sheetName, int rownum) throws IOException {
		
		fi = new FileInputStream(path);
		
		workbook = new XSSFWorkbook(fi);
		
		sheet = workbook.getSheet(sheetName);
		
		row = sheet.getRow(rownum); //on a row
		
		int cellcount = row.getLastCellNum();
		
		workbook.close();
		
		fi.close();
		
		return cellcount;
		
	}
	
	
//now that you know row # and cell # and you can now read from the excel sheet
	
	
	public String getCellData(String sheetName, int rownum, int column) throws IOException {
		
		fi = new FileInputStream(path);
		
		workbook = new XSSFWorkbook(fi);
		
		sheet = workbook.getSheet(sheetName);
		
		row = sheet.getRow(rownum);
		
		cell = row.getCell(column);
		
		
		//will return the formatted cell value as a string regardless of a the cell value
		
		DataFormatter formatter = new DataFormatter ();
		
		String data;
		
		
		try {
			
		data = formatter.formatCellValue(cell); 
		
		} catch (Exception e) {
			
			data = ""; //if no data, show me an emptry string, not any null. java cannot handle null. 
			
		} //close try
		
		
		
		workbook.close();
		
		fi.close();
		
		return data;
		
		
	}//close method
	
	
	
	
//method to write or input value in the excel file. 
	
	
	public void setCellData (String sheetName, int rownum, int column, String data) throws IOException {
		
		File xlfile = new File(path);
		
		//if condition 
		
		if (!xlfile.exists()) {
			
		
		workbook = new XSSFWorkbook();
		
		fo = new FileOutputStream(path); 
		
		workbook.write(fo);
		
		
		}//if condition close
		
		
		fi = new FileInputStream(path);
		
		workbook = new XSSFWorkbook(fi);
		
		
		if(workbook.getSheetIndex(sheetName) == -1)
			
			workbook.createSheet(sheetName); 
		
		sheet = workbook.getSheet(sheetName);
		
		
		if (sheet.getRow(rownum) == null)
			
			sheet.createRow(rownum);

		row = sheet.getRow(rownum);
		
		
		cell = row.createCell(column);
		
		cell.setCellValue(data);
		
		
		fo = new FileOutputStream(path); 
		
		workbook.write(fo);
		
		
		workbook.close();
		
		fi.close();
		
		fo.close();
	
		
		
		
		
	}//method close
	
	
	
	
	
	
	
	
	
	
	
}
