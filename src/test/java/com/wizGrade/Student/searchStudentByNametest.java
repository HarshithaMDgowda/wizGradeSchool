package com.wizGrade.Student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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

public class searchStudentByNametest {
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
		String search=elib.getExcelData("Sheet1", 3, 3)+intRanNum;
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
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wlib.waitForElementInDOM(driver);
		driver.get(URL);

		//step4 login to app
		driver.findElement(By.name("email")).sendKeys(Adminemailid);
		driver.findElement(By.name("password")).sendKeys(Adminpassword);
		driver.findElement(By.id("btnSubmit")).click();

		//step 5 navigate to student
		driver.findElement(By.xpath("//span[text()='Student']")).click();

		//step 6 navigate all student
		driver.findElement(By.xpath("//a[@href='all_student.php']")).click();


		//step 7 select grade from dropdown
		//Select grade = new Select(driver.findElement(By.name("grade")));
		//grade.selectByVisibleText("grade1");
		WebElement element = driver.findElement(By.name("grade"));
		wlib.select(element, 2);

		//step 9 save
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

		//step 10 student details
		WebElement all = driver.findElement(By.xpath("//a[@href='#modalviewform']"));
		String ActTitle = all.getText();
		if (search.contains(ActTitle)) {
			System.out.println("student displayed");
		}
		else {
			System.out.println("not displayed");
		}
		//step 10 logout
		driver.close();
	}
}
