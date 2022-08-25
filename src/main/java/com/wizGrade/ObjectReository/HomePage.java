package com.wizGrade.ObjectReository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='Dashboard']")
	private WebElement dashboardElement;
	
	@FindBy(xpath = "//span[.='Toggle navigation']")
	private WebElement Togglenavigation;
	
	@FindBy(xpath="//span[.='6']")
	private WebElement notification;
	
	@FindBy(id="dropdown_menu_frequest")
	private WebElement notification2;
	
	@FindBy(xpath="//li[@class='dropdown messages-menu open']")
	private WebElement notification3;
	
	@FindBy(xpath="//span[.='Ingenious Developer1']")
	private WebElement IngeniousDeveloper1;
	
	@FindBy(xpath ="//a[.='Sign out']" )
	private WebElement Signout;
	
	
		public WebElement getDashboardElement() {
		return dashboardElement;
	}

	public WebElement getTogglenavigation() {
		return Togglenavigation;
	}

	public WebElement getNotification() {
		return notification;
	}

	public WebElement getNotification2() {
		return notification2;
	}

	public WebElement getNotification3() {
		return notification3;
	}
	public WebElement getIngeniousDeveloper1() {
		return IngeniousDeveloper1;
	}

	public WebElement getSignout() {
		return Signout;
	}
	public void SignOut() {
	WebDriver driver = null;
	Actions act=new Actions(driver);
	act.moveToElement(IngeniousDeveloper1).perform();
	IngeniousDeveloper1.click();
	Signout.click();
	
	}
	}
	
	
	

