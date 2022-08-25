package com.student.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.formula.functions.FinanceLib;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wizGrade.GenericFiles.ExcelUtility;

public class StudentGradetest2 {
	@Test(dataProvider = "selectagradetest")
	public void selectagradetest() throws EncryptedDocumentException, IOException {
		FileInputStream fileexcel=new FileInputStream(".\\Data\\Test_Case_Template.xlsx");
		Workbook wb = WorkbookFactory.create(fileexcel);
		String data=wb.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
		String data1=wb.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
		String data2=wb.getSheet("Sheet1").getRow(0).getCell(2).getStringCellValue();
		String data3=wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String data4=wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String data5=wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		String data6=wb.getSheet("Sheet1").getRow(2).getCell(0).getStringCellValue();
		String data7=wb.getSheet("Sheet1").getRow(2).getCell(1).getStringCellValue();
		String data8=wb.getSheet("Sheet1").getRow(2).getCell(2).getStringCellValue();
		
		
		
	}
	

}
