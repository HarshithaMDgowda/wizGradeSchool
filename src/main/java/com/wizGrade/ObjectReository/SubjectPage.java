package com.wizGrade.ObjectReository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubjectPage {
WebDriver driver;
public SubjectPage(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
//navigate to subject
@FindBy(xpath="//span[text()='Subject']")
private WebElement studentLink;
//provide sub name
@FindBy(name="name")
private WebElement Subname;
//submit
@FindBy(xpath="//button[@type='submit']")
private WebElement clickSubmit;
//verify All student page
@FindBy(xpath = "//h3[.='All Subject']")
private WebElement allStudent;

public WebDriver getDriver() {
	return driver;
}
public WebElement getStudentLink() {
	return studentLink;
}
public WebElement getSubname() {
	return Subname;
}
public WebElement getClickSubmit() {
	return clickSubmit;
}
public WebElement getAllStudent() {
	return allStudent;
}
public void Subjectname(String Subject) {
	
	Subname.sendKeys(Subject);
}	
public String verifySubject(String name)
{
String text = driver.findElement(By.xpath("//td[contains(.,'"+name+"')]")).getText();
return text;
}
}
