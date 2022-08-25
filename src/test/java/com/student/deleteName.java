package com.student;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class deleteName {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver= new ChromeDriver();
	driver.get("http://rmgtestingserver:8888/index.php?action=Login&module=Users");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	
	String Expectedmsg = "tyss";
	boolean flag=false;
	int rowCount=0;
	List<WebElement> lst = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]"));
for(WebElement wb:lst) {
	rowCount++;
	String actualMessage = wb.getText();
	if(actualMessage.equals(Expectedmsg)) {
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[5]/td[3]"));
		break;
	}
	
}
	if(!flag) {
		System.out.println("is not available");
	}
}
}

