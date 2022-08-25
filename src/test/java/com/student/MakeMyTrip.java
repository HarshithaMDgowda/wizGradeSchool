package com.student;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
	String enter = s.next();
	
			
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.makemytrip.com/flight/search?itinerary=DEL-BLR-03/08/2022&tripType=O&paxType=A-1_C-0_I-0&intl=false&cabinClass=E&ccde=IN&lang=eng");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		//driver.findElement(By.xpath("//a[text()='Search']")).click();
	
driver.findElement(By.xpath("//button[.='OKAY, GOT IT!']")).click();
	
		driver.findElement(By.xpath("//p[text()='Popular Filters']/../descendant::span[text()='Refundable Fares']/ancestor::label[@class='makeFlex spaceBtwCenter appendBottom12 pointer ']/descendant::span[@class='box']")).click();


	}

}

