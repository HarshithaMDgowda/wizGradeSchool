package com.TestNGimplement.wizGrade;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wizGrade.GenericFiles.BaseClass;
import com.wizGrade.ObjectReository.AllStudentPage;
import com.wizGrade.ObjectReository.LeaveStudentPage;

public class StudentTest extends BaseClass {
@Test(groups = "regression")
public void activeStudentTest() throws Throwable {
	int intRanNum =jlib.getRanDomNumber();
	String Search=elib.getExcelData("Sheet1", 7, 4)+intRanNum;
	String name="sa";
	// navigate to student
		AllStudentPage student=new AllStudentPage(driver);
		student.getStudentlink().click();
		//navigate to leavestudent
		LeaveStudentPage leave=new LeaveStudentPage(driver);
		leave.getLeavestudentpage().click();
		leave.getClickactive().click();
		leave.getClickyesbutton().click();
		Thread.sleep(5000);
		leave.getgradewait().click();
		leave.Grade(1);
		leave.getSelectSub().click();
		leave.getClickSubmit().click();
		wlib.waitForElementInDOM(driver);
		leave.getClickPaid().click();
		//explicit wait
		Thread.sleep(6000);
		//navigate to student
		AllStudentPage allStudentPage=new AllStudentPage(driver);
		WebElement ele1 = allStudentPage.getStudentlink();
		wlib.waitForElement(driver, ele1);
		allStudentPage.getStudentlink().click();
		//navigate to all studentpage
		leave.getAllstudentpage().click();
		//select grade  
		leave.Grade(2);
		//click on submit
		leave.getClicksubbtn().click();
		//verify details
	//	WebElement all = driver.findElement(By.xpath("//a[@href='#modalviewform']"));
	//	String ActTitle = all.getText();
		/*if (Search.contains(ActTitle)) {
			System.out.println("student displayed");
		}
		else {
		System.out.println("not displayed");
		
}*/
		LeaveStudentPage lPage=new LeaveStudentPage(driver);
	String actual = lPage.allstudentpageverify(name);
		String expected = name;
		Assert.assertEquals(actual, expected);
		//Assert.assertNotEquals(ActTitle, Search);
}
}
