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

public class createStudentDetailsTest {
public static void main(String[] args) throws IOException {
	//read all neccessary common data
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
		driver.findElement(By.id("index_number")).sendKeys("1234");
		driver.findElement(By.name("full_name")).sendKeys("harshitha");
		driver.findElement(By.id("i_name")).sendKeys("m d");
		driver.findElement(By.name("address")).sendKeys("bengaluru");
		driver.findElement(By.id("email")).sendKeys("harshithamd958@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("111-222-2333");
		driver.findElement(By.id("b_date")).sendKeys("30/05/1998");
		driver.findElement(By.id("gender")).click();
		driver.findElement(By.id("output")).click();
		driver.findElement(By.id("g_index")).click();
		driver.findElement(By.id("g_full_name")).sendKeys("harsh");
		driver.findElement(By.id("g_i_name")).sendKeys("m");
		driver.findElement(By.id("g_address")).sendKeys("bengaluru");
	     driver.findElement(By.id("g_email")).sendKeys("harshi@gmail.com");
	     driver.findElement(By.id("g_phone")).sendKeys("222-333-4567");
	     driver.findElement(By.id("g_b_date")).sendKeys("30/06/1981");
	     driver.findElement(By.id("g_gender")).sendKeys("");
	     
		
		
		
	




		
	}
	
}
}


