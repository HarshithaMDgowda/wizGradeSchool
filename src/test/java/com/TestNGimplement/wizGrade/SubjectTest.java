package com.TestNGimplement.wizGrade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wizGrade.GenericFiles.BaseClass;
import com.wizGrade.ObjectReository.AllStudentPage;
import com.wizGrade.ObjectReository.LeaveStudentPage;
import com.wizGrade.ObjectReository.SubjectPage;

public class SubjectTest extends BaseClass{
	String name = "Subject 1";
	@Test(groups = "smoke")
	public void createSubjecttest() throws Throwable {
		int intRanNum =jlib.getRanDomNumber();
		String Subject=elib.getExcelData("Sheet1", 1, 2)+intRanNum;
		String name="Subject 1";
		//navigate to subject
		SubjectPage sub = new SubjectPage(driver);
		wlib.waitForElement(driver, sub.getStudentLink());
		sub.getStudentLink().click();
         sub.Subjectname(Subject);
		sub.getClickSubmit().click();
        //verify
		//SubjectPage sub1=new SubjectPage(driver);
		//sub1.getAllStudent();
		//String actualContains=sub1.getAllStudent().getText();
		/*if(actualContains.contains(Subject)) {
			System.out.println("displayed");
		}
		else {
			System.out.println("not displayed");
		}*/
		SubjectPage sub1 = new SubjectPage(driver);
		String actual = sub1.verifySubject(name);
		String expected = name;
		Assert.assertEquals(actual, expected);
	}
} 

	


