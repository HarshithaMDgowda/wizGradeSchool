package com.wizGrade.Student;

import java.io.File;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class addStudentAndVerifyDetailstest {
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
		Thread.sleep(50000);
		String URL=flib.getPropertyKeyValue("url");
		String Browser = flib.getPropertyKeyValue("browser");
		String Adminemailid = flib.getPropertyKeyValue("adminemailid");
		String Adminpassword = flib.getPropertyKeyValue("adminpassword");
		String Photo = flib.getPropertyKeyValue("photo");
		String Photo1 = flib.getPropertyKeyValue("photo1");

		//read all necessary from excel sheet
		//FileInputStream fileexcel=new FileInputStream(".\\Data\\Test_Case_Template.xlsx");
		//Workbook wb = WorkbookFactory.create(fileexcel);
		String IndexNumber=elib.getExcelData("Sheet1", 9, 2)+intRanNum;
		String FullName=elib.getExcelData("Sheet1", 9, 3)+intRanNum;
		String NameWithInitials=elib.getExcelData("Sheet1", 9, 4)+intRanNum;
		String Address=elib.getExcelData("Sheet1", 9, 5)+intRanNum;
		String Email=intRanNum+elib.getExcelData("Sheet1", 9, 6);
		String Phone=intRanNum+elib.getExcelData("Sheet1", 9, 7);
		String DateofBirth=elib.getExcelData("Sheet1", 9, 8);

		String FullName1=elib.getExcelData("Sheet1", 9, 12)+intRanNum;
		String NameWithInitials1=elib.getExcelData("Sheet1", 9, 13)+intRanNum;
		String Address1=elib.getExcelData("Sheet1", 9, 14)+intRanNum;
		String Email1=intRanNum+elib.getExcelData("Sheet1", 9, 15);
		String Phone1=intRanNum+elib.getExcelData("Sheet1", 9, 16);
		String DateofBirth1=elib.getExcelData("Sheet1", 9, 17);

		String id=elib.getExcelData("Sheet1", 13, 1)+intRanNum;


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

		// step 6 navigate to add student
		driver.findElement(By.xpath("//a[@href='student.php']")).click();

		//read data from excel sheet enter all feilds

		driver.findElement(By.id("index_number")).sendKeys(IndexNumber);
		driver.findElement(By.name("full_name")).sendKeys(FullName);
		driver.findElement(By.id("i_name")).sendKeys(NameWithInitials);
		driver.findElement(By.name("address")).sendKeys(Address);
		driver.findElement(By.id("email")).sendKeys(Email);
		driver.findElement(By.id("phone")).sendKeys(Phone);
		driver.findElement(By.id("b_date")).sendKeys(DateofBirth);

		//Select gender = new Select(driver.findElement(By.name("gender")));
		//gender.selectByVisibleText("Female");
		WebElement element = driver.findElement(By.name("gender"));
		wlib.select(element,2);

		File file=new File(Photo);
		String file1 = file.getAbsolutePath();
		driver.findElement(By.name("fileToUpload")).sendKeys(file1);

		driver.findElement(By.id("g_index"));
		driver.findElement(By.id("g_full_name")).sendKeys(FullName1);
		driver.findElement(By.id("g_i_name")).sendKeys(NameWithInitials1);
		driver.findElement(By.id("g_address")).sendKeys(Address1);
		driver.findElement(By.id("g_email")).sendKeys(Email1);
		driver.findElement(By.id("g_phone")).sendKeys(Phone1) ;
		driver.findElement(By.id("g_b_date")).sendKeys(DateofBirth1);

		//Select gender1 = new Select(driver.findElement(By.name("g_gender")));
		//gender1.selectByVisibleText("Female");
		WebElement element1 = driver.findElement(By.name("g_gender"));
		wlib.select(element1,1);

		File FILE=new File(Photo1);
		String FILE1 = FILE.getAbsolutePath();
		driver.findElement(By.name("g_fileToUpload")).sendKeys(FILE1);
		driver.findElement(By.xpath("//button[text()='Next']")).click();

		// select a grade from dropdown
		Select grade = new Select(driver.findElement(By.name("grade")));
		grade.selectByVisibleText("Grade");

		//select subject checkbox 
		driver.findElement(By.xpath("//div[@class='panel-body']/table/tbody/tr[1]/td[1]")).click();

		//click on submit
		driver.findElement(By.xpath("//button[@class='btn btn-info ']")).click();

		//click on paid
		Thread.sleep(6000);
		//driver.findElement(By.id("btnSubmit1")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-md']")).click();
		 Thread.sleep(6000);
		//navigate all student
		/*driver.findElement(By.xpath("//a[@href='all_student.php']")).click();

		//select grade from dropdown
		Select grade2 = new Select(driver.findElement(By.name("grade")));
		grade2.selectByVisibleText("Grade2");

		// click on submit
		driver.findElement(By.id("btnSubmit1")).click();
		//verify
		WebElement all = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]"));
		String ActTitle = all.getText();
		if (id.contains(ActTitle)) {
			System.out.println("student displayed");
		}
		else {
			System.out.println("student not displayed");
		}

		//step 10 logout
		driver.close();*/
 
	}
	}

