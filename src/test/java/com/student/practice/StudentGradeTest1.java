package com.student.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StudentGradeTest1 {
	@Test(dataProvider = "dataProvider_selectgradetest")
	public void selectagradetest(String src, String dst,int index) {
		System.out.println("select grade from "+src+" to "+dst);
	}
	@DataProvider
	public Object[][] dataProvider_selectgradetest(){
		Object[][] objArr=new Object[5][3];
		objArr[0][0]="selectgrade";
		objArr[0][1]="A";
		objArr[0][2]=1;
		
		objArr[1][0]="selectgrade";
		objArr[1][1]="B";
		objArr[1][2]=2;
		
		objArr[2][0]="selectgrade";
		objArr[2][1]="C";
		objArr[2][2]=3;
		
		objArr[3][0]="selectgrade";
		objArr[3][1]="D";
		objArr[3][2]=4;
		
		objArr[4][0]="selectgrade";
		objArr[4][1]="E";
		objArr[4][2]=5;
		return objArr;
		
		
	}
}
