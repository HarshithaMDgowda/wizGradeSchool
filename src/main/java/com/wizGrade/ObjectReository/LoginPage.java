package com.wizGrade.ObjectReository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wizGrade.GenericFiles.WebDriverUtility;

public class LoginPage {
	
	
	//Rule-2 declaration
	@FindBy(name="email")
	private WebElement Email;

	@FindBy(name="password")
	private WebElement Password;

	@FindBy(id="btnSubmit")
	private WebElement Submit;

	//Rule 2 initialization
	public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
//Rule 4 Utilization
	public WebElement getEmail() {
		return Email;
		}
	public WebElement getPassword() {
		return Password;
		}
	public WebElement getSubmit() {
		return Submit;
		}
	public void loginToApp(String Adminemailid, String Adminpassword) throws InterruptedException {
		//login to application
WebDriverUtility wlib=new WebDriverUtility();
wlib.waitAndClick(Email);
		Email.sendKeys(Adminemailid);
		Password.sendKeys(Adminpassword);
		Submit.click();   
	
	}
}

