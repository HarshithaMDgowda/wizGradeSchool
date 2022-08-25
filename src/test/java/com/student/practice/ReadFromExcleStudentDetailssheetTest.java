package com.student.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadFromExcleStudentDetailssheetTest {
public static void main(String[] args) throws IOException {
	WebDriver driver=null;
	FileInputStream fis = new FileInputStream(".\\Data\\CommonData.properties.");
			Properties prop=new Properties();
		prop.load(fis);
		String URL = prop.getProperty("url");
		System.out.println(URL); 
		String Browser = prop.getProperty("browser");
		System.out.println(Browser);
		String Emailid = prop.getProperty("emailid");
		System.out.println(Emailid);
		String Password = prop.getProperty("password");
		System.out.println(Password);
	FileInputStream fileexcel=new FileInputStream(".\\Data\\New Microsoft Office Excel Worksheet.xlsx");
	Workbook wb=WorkbookFactory.create(fileexcel);
	String createStudent=wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
	if(Browser.equalsIgnoreCase("Chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(Browser.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		}
	else {
		{
			System.out.println("incorrect browse");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("email")).sendKeys(Emailid);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.id("btnSubmit")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//span[text()='Student']")).click();
		driver.findElement(By.id("delete_Success")).click();
}
	
	
	
	
}
}  