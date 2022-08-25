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
import com.wizGrade.ObjectReository.LeaveStudentPage;
import com.wizGrade.ObjectReository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class activateStudentverifytest1 {
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
		driver=new FirefoxDriver();	}

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
	//navigate to leavestudent
	LeaveStudentPage leave=new LeaveStudentPage(driver);
	leave.getLeavestudentpage().click();
	leave.getClickactive().click();
	leave.getClickyesbutton().click();
	leave.Grade(1);
	leave.getSelectSub().click();
	leave.getClickSubmit().click();
	wlib.waitForElementInDOM(driver);
	leave.getClickPaid().click();
	//explicit wait
	WebElement ele1 = leave.getAllstudentpage();
	wlib.waitForElement(driver, ele1);
	
	//navigate to all studentpage
	leave.getAllstudentpage().click();
	//select grade  
	leave.Grade(2);
	//click on submit
	leave.getClicksubbtn().click();
	//verify details
	WebElement all = driver.findElement(By.xpath("//a[@href='#modalviewform']"));
	String ActTitle = all.getText();
	if (Search.contains(ActTitle)) {
		System.out.println("student displayed");
	}
	else {
	System.out.println("not displayed");
	//logout
	driver.close();

	}	
}
}
