package com.wizGrade.Student1;

import javax.swing.text.Element;

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
import com.wizGrade.ObjectReository.HomePage;
import com.wizGrade.ObjectReository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeaveStudentandverifytest1 {
public static void main(String[] args) throws Throwable {
	WebDriver driver=null;

	//create an Object to Utility*/
	WebDriverUtility wlib = new WebDriverUtility();
	FileUtility flib = new FileUtility();
	JavaUtility jlib = new JavaUtility();
	ExcelUtility elib = new ExcelUtility();

	//create random number
	//Random ran = new Random();
	//int random=ran.nextInt(500);
	int intRanNum =jlib.getRanDomNumber();

	//read all necessary common data 
	//FileInputStream fis=new FileInputStream(".\\Data\\CommonData.properties");
	//Properties prop = new Properties();
	//prop.load(fis);
	String URL=flib.getPropertyKeyValue("url");
	String Browser = flib.getPropertyKeyValue("browser");
	String Adminemailid = flib.getPropertyKeyValue("adminemailid");
	String Adminpassword = flib.getPropertyKeyValue("adminpassword");

	//read all necessary from excel sheet
	//FileInputStream fileexcel=new FileInputStream(".\\Data\\Test_Case_Template.xlsx");
	//Workbook wb = WorkbookFactory.create(fileexcel);
	String Search=elib.getExcelData("Sheet1", 7, 4)+intRanNum;
	//step3 launch the browser
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
	//driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	//login to app
	driver.get(URL);
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(Adminemailid, Adminpassword);

	// navigate to student
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
	student.getLeaveButton().click();
	student.getClickyes().click();
	//navigate to student
	
Thread.sleep(10000);
 WebElement element1 = driver.findElement(By.xpath("//span[text()='Student']"));
 wlib.waitForElement(driver, element1);
	student.getStudentlink1().click();
	//navigate to leave student
	student.getLeaveStudent().click();	
	Thread.sleep(6000);
  	HomePage h1=new HomePage(driver);
  h1.getIngeniousDeveloper1().click();
	h1.getSignout().click();
	
	//close the browser
	driver.close();
}
}
