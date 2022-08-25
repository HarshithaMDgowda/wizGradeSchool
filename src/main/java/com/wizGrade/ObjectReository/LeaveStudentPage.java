package com.wizGrade.ObjectReository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wizGrade.GenericFiles.WebDriverUtility;

public class LeaveStudentPage {
	WebDriver driver;
	public LeaveStudentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Student']")
	private WebElement Studentlink;

	@FindBy(xpath="//a[@href='student_leave.php']")
	private WebElement Leavestudentpage;
	
	@FindBy(xpath="//table[@class='table table-bordered table-striped dataTable no-footer']/tbody/tr[1]/td[3]/a[text()='Active']")
	private WebElement Clickactive;

	@FindBy(id="btnYes")
	private WebElement Clickyesbutton;
	
	@FindBy(xpath="//div[@class='panel-body']/table/tbody/tr[1]/td[1]")
private WebElement SelectSub;
	
	@FindBy(xpath="//button[@class='btn btn-info ']")
	private WebElement ClickSubmit;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-md']")
	private WebElement ClickPaid;
	
	@FindBy(xpath="//a[@href='all_student.php']")
	private WebElement Allstudentpage;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement Clicksubbtn;
	
	@FindBy(id="grade")
	private WebElement gradewait;
	

	public WebElement getStudentlink() {
		return Studentlink;
	}

	public WebElement getLeavestudentpage() {
		return Leavestudentpage;
	}

	public WebElement getClickactive() {
		return Clickactive;
	}

	public WebElement getClickyesbutton() {
		return Clickyesbutton;
	}

	public WebElement getSelectSub() {
		return SelectSub;
	}

	public WebElement getClickSubmit() {
		return ClickSubmit;
	}

	public WebElement getClickPaid() {
		return ClickPaid;
	}

	public WebElement getAllstudentpage() {
		return Allstudentpage;
	}

	public WebElement getClicksubbtn() {
		return Clicksubbtn;
	}
	public WebElement getgradewait() {
		return gradewait;
	}
	public String verifyLeavePage(String name)
	{
		String text = driver.findElement(By.xpath("//td[contains(.,'"+name+"')]")).getText();
		return text;
	}
	public void Grade(int index) {
		WebDriverUtility wlib=new WebDriverUtility();
		WebElement element=driver.findElement(By.id("grade"));
		wlib.select(element, index);
		}
	public String allstudentpageverify(String name) {
		String text = driver.findElement(By.xpath("//td[contains(.,'"+name+"')]")).getText();
		return name;
		
	}
	 }
	
	
	

