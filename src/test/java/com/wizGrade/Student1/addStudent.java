package com.wizGrade.Student1;

import java.io.File;

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
import com.wizGrade.ObjectReository.StudentPreviewPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class addStudent {
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

		//String id=elib.getExcelData("Sheet1", 13, 1)+intRanNum;

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
		//navigate to add student
		StudentPreviewPage sp=new StudentPreviewPage(driver);
	sp.getAddStudentlink().click();
	sp.getIndexNumber().sendKeys(IndexNumber);
	sp.getFullname().sendKeys(FullName);                                                                                 
	sp.getIname().sendKeys(NameWithInitials);
	sp.getAddress().sendKeys(Address);
	sp.getEMAIL().sendKeys(Email);
	sp.getPhone().sendKeys(Phone);
	sp.getBirthdate().sendKeys(DateofBirth);
	WebElement element = driver.findElement(By.name("gender"));
	wlib.select(element,2);
	File file=new File(Photo);
	String file1 = file.getAbsolutePath();
	driver.findElement(By.name("fileToUpload")).sendKeys(file1);
	
	sp.getGindexNumber().click();
	sp.getGfullname().sendKeys(FullName1);
	sp.getGiname().sendKeys(NameWithInitials1);
	sp.getGAddress().sendKeys(Address1);
	sp.getGEMAIL().sendKeys(Email1);
	sp.getGPhone().sendKeys(Phone1);
	sp.getGbirthdate().sendKeys(DateofBirth1);
	WebElement element1 = driver.findElement(By.name("g_gender"));
	wlib.select(element1,1);

	File FILE=new File(Photo1);
	String FILE1 = FILE.getAbsolutePath();
	driver.findElement(By.name("g_fileToUpload")).sendKeys(FILE1);
	driver.findElement(By.xpath("//button[text()='Next']")).click();
	
	}	
}
