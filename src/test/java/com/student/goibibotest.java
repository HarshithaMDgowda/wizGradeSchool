package com.student;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class goibibotest {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.goibibo.com/");
	Actions act=new Actions(driver);
	act.moveByOffset(10, 10).click().perform();
	driver.findElement(By.xpath("//span[@class='sc-kfPuZi dprjVP fswDownArrow']")).click();
	driver.findElement(By.xpath("//div[text()='August 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='12']")).click();
	driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
	driver.findElement(By.xpath("//div[text()='September 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='12']")).click();
driver.findElement(By.xpath("//span[@class='fswTrvl__done']")).click();
//p[.='Adults']/
//xpath====>>>>>>>>>>>//p[text()='Adults']/../child::div[@class='M7 1v12.5M1 7h12.5']/span[@class='sc-faUpoM jSgnBw']
//(//p[text()='Adults']/../div[@class='sc-clIzBv gFdmFA']//*[name()='svg'])[2]==>>>>>>xpath to add
//(//p[text()='Infants']/../div[@class='sc-clIzBv gFdmFA']//*[name()='svg'])[2]
driver.findElement(By.xpath("//p[text()='Adults']/../div[@class='sc-clIzBv gFdmFA']//*[name()='svg'])[2]")).click();
driver.close();
}
}
