package com.TestNGimplement.wizGrade;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wizGrade.GenericFiles.BaseClass;
import com.wizGrade.ObjectReository.AllStudentPage;
import com.wizGrade.ObjectReository.LeaveStudentPage;

public class LeaveStusentTest extends BaseClass{
	@Test(groups = "regression")
	public void Leavestudentest() throws Throwable {
		// navigate to student
		//String Subject=elib.getExcelData("Sheet1", 13, 1);
		String name = "sa";
		AllStudentPage student=new AllStudentPage(driver);
		student.getStudentlink().click();
		// navigate all student
		student.getAllstudentpage().click();

		//select grade
		student.Grade(1);
		//click on submit
		student.getSubmitButton().click();
		//select student and click on Leavebutton and click on yes
		//driver.navigate().refresh();
		WebElement ele1 = student.getLeaveButton();
		wlib.waitForElement(driver, ele1);
		student.leaveStudent(name);
		//student.getLeaveButton().click();
		student.getClickyes().click();
		//navigate to student
        Thread.sleep(10000);
		WebElement element1 = driver.findElement(By.xpath("//span[text()='Student']"));
		wlib.waitForElement(driver, element1);
		student.getStudentlink1().click();
		//navigate to leave student
		student.getLeaveStudent().click();
		LeaveStudentPage lP=new LeaveStudentPage(driver);
		String actual = lP.verifyLeavePage(name);
		String expected = name;
		Assert.assertEquals(actual, expected);
		//WebElement act = driver.findElement(By.xpath("//section[@class='content-header']"));
		//WebElement actString=student.getLeaveStudent();
		//Assert.assertEquals(act, Subject);
	}
}
