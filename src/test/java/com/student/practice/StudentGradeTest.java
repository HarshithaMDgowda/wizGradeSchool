package com.student.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StudentGradeTest {
	@Test(dataProvider = "dataProvider_selectgradetest")
	public void selectagradetest(String src, String dst) {
		System.out.println("select grade from "+src+" to "+dst);
	}
	@DataProvider
	
	public Object[][] dataProvider_selectgradetest(){
		Object[][] objArr=new Object[5][2];
		objArr[0][0]="selectgrade";
		objArr[0][1]="A";
		
		objArr[1][0]="selectgrade";
		objArr[1][1]="B";
		
		objArr[2][0]="selectgrade";
		objArr[2][1]="C";
		
		objArr[3][0]="selectgrade";
		objArr[3][1]="D";
		
		objArr[4][0]="selectgrade";
		objArr[4][1]="E";
		return objArr;
		
		
	}
}
