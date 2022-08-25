package com.student;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Goibibo {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.goibibo.com/");
	Actions act=new Actions(driver);
	act.moveByOffset(10, 10).click().perform();
	//driver.findElement(By.xpath("//span[text()='From']"));//div[@class='DayPicker-wrapper']/desandant::div[text()='August 2022']
	//driver.findElement(By.xpath("//span[text()='To']"));
	//driver.findElement(By.xpath("//span[text()='Departure']"));
	driver.findElement(By.xpath("//span[@class='sc-kfPuZi dprjVP fswDownArrow']")).click();
	//driver.findElement(By.xpath("//span[@class='sc-kfPuZi dprjVP fswDownArrow']"));
	//arrow button
	//driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
	//to slect date
	driver.findElement(By.xpath("//div[text()='August 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='12'  ]")).click();
	//driver.findElement(By.xpath("//div[text()='August 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='10']")).click();
driver.close();//div[@class='sc-lbhJGD bHgpcs']
}
}
