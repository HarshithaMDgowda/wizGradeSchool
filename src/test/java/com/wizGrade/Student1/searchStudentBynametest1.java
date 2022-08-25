package com.wizGrade.Student1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.wizGrade.GenericFiles.ExcelUtility;
import com.wizGrade.GenericFiles.FileUtility;
import com.wizGrade.GenericFiles.JavaUtility;
import com.wizGrade.GenericFiles.WebDriverUtility;
import com.wizGrade.ObjectReository.AllStudentPage;
import com.wizGrade.ObjectReository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class searchStudentBynametest1 {
public static void main(String[] args) throws Throwable {
	WebDriver driver=null;
	//create an Object to Utility*/
	WebDriverUtility wlib = new WebDriverUtility();
	FileUtility flib = new FileUtility();
	JavaUtility jlib = new JavaUtility();
	ExcelUtility elib = new ExcelUtility();

	int intRanNum =jlib.getRanDomNumber();
	String URL=flib.getPropertyKeyValue("url");
	String Browser = flib.getPropertyKeyValue("browser");
	String Adminemailid = flib.getPropertyKeyValue("adminemailid");
	String Adminpassword = flib.getPropertyKeyValue("adminpassword");
	String search=elib.getExcelData("Sheet1", 3, 3)+intRanNum;
	if(Browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

	}
	else if (Browser.equalsIgnoreCase("FireFox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else {
		System.out.println("invalid browser name");
	}
	//login to app

	driver.get(URL);
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(Adminemailid, Adminpassword);
	
	//navigate to student
	AllStudentPage student = new AllStudentPage(driver);
	student.getStudentlink().click();
	//navigate to allstudent
	student.getAllstudentpage().click();
	//select grdae from dropdown
	//WebElement element = driver.findElement(By.name("grade"));
	//wlib.select(element, 2);
	student.Grade(2);
	//click on submit
	student.getSubmitButton().click();
	// student details
	String title = student.getStudentdetails().getText();
	if (search.contains(title)) {
				System.out.println("student displayed");
			}
			else {
				System.out.println("not displayed");
			}
			//step 10 logout
			driver.close();
}
 
}
