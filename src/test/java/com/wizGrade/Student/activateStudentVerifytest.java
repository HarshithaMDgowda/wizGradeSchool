package com.wizGrade.Student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.NonWritableChannelException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.genetics.ElitisticListPopulation;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jsoup.select.Evaluator.Id;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.wizGrade.GenericFiles.ExcelUtility;
import com.wizGrade.GenericFiles.FileUtility;
import com.wizGrade.GenericFiles.JavaUtility;
import com.wizGrade.GenericFiles.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class activateStudentVerifytest {
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
	// fis=new FileInputStream(".\\Data\\CommonData.properties");
	//Properties prop = new Properties();
	//prop.load(fis);
	String URL=flib.getPropertyKeyValue("url");
	String Browser = flib.getPropertyKeyValue("browser");
	String Adminemailid = flib.getPropertyKeyValue("adminemailid");
	String Adminpassword = flib.getPropertyKeyValue("adminpassword");
	//read all necessary from excel sheet
	//FileInputStream fileexcel=new FileInputStream(".\\Data\\Test_Case_Template.xlsx");
	//Workbook wb = WorkbookFactory.create(fileexcel);
	String Search=elib.getExcelData("Sheet1", 5, 6)+intRanNum;
	// launch the browser
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
driver.manage().window().maximize();
wlib.waitForElementInDOM(driver);
//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.get(URL);

//login to app
driver.findElement(By.name("email")).sendKeys(Adminemailid);
driver.findElement(By.name("password")).sendKeys(Adminpassword);
driver.findElement(By.id("btnSubmit")).click();

// navigate to student
driver.findElement(By.xpath("//span[text()='Student']")).click();

// navigate to leave student page
driver.findElement(By.xpath("//a[@href='student_leave.php']")).click();

//click on active
driver.findElement(By.xpath("//table[@class='table table-bordered table-striped dataTable no-footer']/tbody/tr[1]/td[3]/a[text()='Active']")).click();
//table[@class='table table-bordered table-striped dataTable no-footer']/tbody/tr[1]/td[3]/a[text()='Active']
//driver.findElement(By.name("name")).sendKeys(createSub +random);

// click on yes
driver.findElement(By.id("btnYes")).click();

//grade from dropdown
WebElement element = driver.findElement(By.id("grade"));
wlib.select(element,1);
//Select grade = new Select(driver.findElement(By.name("grade")));
//grade.selectByVisibleText("Grade");


//select subject and submit
driver.findElement(By.xpath("//div[@class='panel-body']/table/tbody/tr[1]/td[1]")).click();
driver.findElement(By.xpath("//button[@class='btn btn-info ']")).click();

//click on paid button
driver.findElement(By.xpath("//button[@class='btn btn-primary btn-md']")).click();

//navigate to all student page
driver.findElement(By.xpath("//a[@href='all_student.php']")).click();

//grade from dropdown
WebElement element1 = driver.findElement(By.name("grade"));
wlib.select(element1, 1);
// click on submit
driver.findElement(By.xpath("//button[text()='Submit']")).click();

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
