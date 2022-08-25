package com.wizGrade.Student;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wizGrade.GenericFiles.ExcelUtility;
import com.wizGrade.GenericFiles.FileUtility;
import com.wizGrade.GenericFiles.JavaUtility;
import com.wizGrade.GenericFiles.WebDriverUtility;
import com.wizGrade.ObjectReository.AllStudentPage;
import com.wizGrade.ObjectReository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class leaveStudentandVerifytest {
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

		//select grade from dropdown
		//driver.findElement(By.xpath("//select[@id='grade']"));
		student.getGrade();
		//Select sel = new Select(driver.findElement(By.xpath("//select[@id='grade']")));
		//sel.selectByVisibleText("Grade 2");
		student.Grade(2);
		//  click on submit
		student.getSubmitButton().click();
		Thread.sleep(3000);

		// select student and click on leave and click on yes
		//driver.findElement(By.xpath("//table[@class='table table-bordered table-striped dataTable no-footer']/tbody/tr[contains(.,'s1')]/descendant::a[text()='Leave']")).click();
		//driver.findElement(By.id("btnYes")).click();
		//student.getLeaveButton().click();
		
		/*student.getClickyes().click();
		
		//Thread.sleep(6000);
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(	By.xpath("//span[text()='Student']']")));
		WebElement ele1 = driver.findElement(By.xpath("//span[text()='Student']']"));

		//click on student
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[text()='Student']")).click();

		WebDriverWait wait1=new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[text()=' Leave Student']")));

		//step 10 navigate to leave student page
		driver.findElement(By.xpath("//a[text()=' Leave Student']")).click();

		List<WebElement> allstudent = driver.findElements(By.xpath("//table[@class='table table-bordered table-striped dataTable no-footer']/tbody/tr/td[2]"));
		ArrayList<String> studentlist=new ArrayList<String>();

		for(WebElement all:allstudent) {
			String stud = all.getText();

			studentlist.add(stud);
		}

		if (studentlist.contains(Search)) {
			System.out.println("displayed");
		}

		else {
			System.out.println("not displayed");
		}
		//driver.findElement(By.xpath("//h3[text()='Leave Student']"));

		//step 11 logout
		driver.close();*/

	}

}
