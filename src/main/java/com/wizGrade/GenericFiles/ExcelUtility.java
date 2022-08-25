package com.wizGrade.GenericFiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *  which is used to handle excel sheet
 * @author Harshitha
 *
 */

public class ExcelUtility {	
	
	/**
	 * it is used to read data from excel
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName , int rowNum , int celNum) throws Throwable  {
		FileInputStream fileexcel=new FileInputStream(".\\Data\\Test_Case_Template.xlsx");
		Workbook wb = WorkbookFactory.create(fileexcel);
		String data=wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		return data;
		
	}
	/**
	 * used to get the last used row number on specified Sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis  = new FileInputStream(".\\Data\\Test_Case_Template.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}
	/**
	 * used to write data back to Excel based on below parameter
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws Throwable
	 */
	public void setDataExcel(String sheetName , int rowNum, int celNum ,String data) throws Throwable {
		FileInputStream fis  = new FileInputStream(".\\Data\\Test_Case_Template.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(celNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(".\\Data\\Test_Case_Template.xlsx");
		wb.write(fos);
		wb.close();
		
	}


}


