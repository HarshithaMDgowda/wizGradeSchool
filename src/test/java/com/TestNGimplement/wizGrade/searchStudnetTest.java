package com.TestNGimplement.wizGrade;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.wizGrade.GenericFiles.BaseClass;
import com.wizGrade.ObjectReository.AllStudentPage;

@Listeners( com.wizGrade.GenericFiles.Listenerimplementation.class)
public class searchStudnetTest extends BaseClass {
	@Test//(retryAnalyzer = com.wizGrade.GenericFiles.retryimplementation.class)
	public void Searchstudent() throws Throwable {
		int intRanNum =jlib.getRanDomNumber();
		String search=elib.getExcelData("Sheet1", 3, 3);
		
	     String name = "s1";
		//navigate to student
		AllStudentPage student = new AllStudentPage(driver);
		wlib.waitForElement(driver, student.getStudentlink());
		student.getStudentlink().click();
		//navigate to allstudent   
		
		student.getAllstudentpage().click();
		//select grdae from dropdown
		//WebElement element = driver.findElement(By.name("grade"));
		//wlib.select(element, 2);
		student.Grade(2);
		//click on submit
		student.getSubmitButton().click();
		student.SearchByname(search);
		// student details
		//String title = student.getStudentdetails().getText();
		/*if (search.contains(title)) {
			System.out.println("student displayed");
		}
		else {
			System.out.println("not displayed");
		}
		//System.out.println("displayed");
	 // Assert.fail();*/
		String actual = student.verifyStudent(name);
		String expected = name;
		Assert.assertEquals(actual, expected);
	}
}
