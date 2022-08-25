package com.wizGrade.Student1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.wizGrade.GenericFiles.ExcelUtility;
import com.wizGrade.GenericFiles.FileUtility;
import com.wizGrade.GenericFiles.JavaUtility;
import com.wizGrade.GenericFiles.WebDriverUtility;
import com.wizGrade.ObjectReository.HomePage;
import com.wizGrade.ObjectReository.LoginPage;
import com.wizGrade.ObjectReository.SubjectPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateSubject1 {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		//create an Object to Utility*/
		WebDriverUtility wlib = new WebDriverUtility();
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		ExcelUtility elib = new ExcelUtility();

		int intRanNum =jlib.getRanDomNumber();
		String Subject=elib.getExcelData("Sheet1", 1, 2)+intRanNum;
		String URL=flib.getPropertyKeyValue("url");
		String Browser = flib.getPropertyKeyValue("browser");
		String Adminemailid = flib.getPropertyKeyValue("adminemailid");
		String Adminpassword = flib.getPropertyKeyValue("adminpassword");
		
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

		//navigate to subject
		SubjectPage sub = new SubjectPage(driver);
		sub.getStudentLink().click();
		sub.Subjectname(Subject);
		sub.getClickSubmit().click();
		
		//verify
		SubjectPage sub1=new SubjectPage(driver);
	   sub1.getAllStudent();
	   String actualContains=sub1.getAllStudent().getText();
	   if(actualContains.contains(Subject)) {
		   System.out.println("displayed");
	   }
	   else {
		System.out.println("not displayed");
	}
	   //signout
	  // Home h=new Home(driver);
	 // wlib.waitForElement(driver,h.getIngeniousDeveloper1());
	   Thread.sleep(6000);
	  
	  	HomePage h1=new HomePage(driver);
	  h1.getIngeniousDeveloper1().click();
		h1.getSignout().click();
		System.out.println("logout");
		
		//close the browser
		driver.close();




	}


}
