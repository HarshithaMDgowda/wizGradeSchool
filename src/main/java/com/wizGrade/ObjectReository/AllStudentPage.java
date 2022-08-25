
package com.wizGrade.ObjectReository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.wizGrade.GenericFiles.WebDriverUtility;

public class AllStudentPage {
	WebDriver driver;
	public AllStudentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Student']")
	private WebElement Studentlink;

	@FindBy(xpath="//a[@href='all_student.php']")
	private WebElement Allstudentpage;
	
	@FindBy(id="grade")
	private WebElement Grade;

	@FindBy(xpath="//button[.='Submit']")
	private WebElement SubmitButton;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement Search;
	
	@FindBy(xpath="//table[@class='table table-bordered table-striped dataTable no-footer']/tbody/tr[contains(.,'h')]/descendant::a[text()='Leave']")
private WebElement LeaveButton;
	
	@FindBy(id="btnYes")
	private WebElement Clickyes ;
	
	@FindBy(xpath="//span[text()='Student']")
	private WebElement Studentlink1;
	
	@FindBy(xpath="//a[text()=' Leave Student']")
	private WebElement LeaveStudent;
	
	@FindBy(xpath="//table[@class='table table-bordered table-striped dataTable no-footer']/tbody/tr/td[2]")
	private WebElement Allstudentpageddisplay;
	
	@FindBy(xpath="//a[@href='#modalviewform']")
	private WebElement Studentdetails;
		
	public WebElement getStudentlink() {
		return Studentlink;
	}
	public WebElement getAllstudentpage() {
		return Allstudentpage;
	}
	public WebElement getGrade() {
		return Grade;
	}
	public WebElement getSubmitButton() {
		return SubmitButton;
	}
	public WebElement getSearch() {
		return Search;
	}
	public WebElement getLeaveButton() {
		return LeaveButton;
	}
	public WebElement getClickyes() {
		return Clickyes;
	}
	public WebElement getStudentlink1() {
		return Studentlink1;
	}
	public WebElement getLeaveStudent() {
		return LeaveStudent;
	}
	public WebElement getAllstudentpageddisplay() {
		return Allstudentpageddisplay;
	}
	public WebElement getStudentdetails() {
		return Studentdetails;
	}
	//serach student by name
	public void SearchByname(String search) {
		Search.sendKeys(search);
			
	}
	public void Grade(int index) {
		WebDriverUtility wlib=new WebDriverUtility();
		WebElement element=driver.findElement(By.id("grade"));
		wlib.select(element, index);
		
		
	}
	public void leaveStudent(String name) {
		driver.findElement(By.xpath("//table[@class='table table-bordered table-striped dataTable no-footer']/tbody/tr[contains(.,'"+name+"')]/descendant::a[text()='Leave']")).click();
	}
	
	public void explicit(WebElement element) {
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.waitForElement(driver, element);
		element=driver.findElement(By.xpath("//span[text()='Student']"));
		
		}
	public String verifyStudent(String name) {
		String text = driver.findElement(By.xpath("//td[contains(.,'"+name+"')]")).getText();
		return text;
		
	}
}
	
	
		
	
	

