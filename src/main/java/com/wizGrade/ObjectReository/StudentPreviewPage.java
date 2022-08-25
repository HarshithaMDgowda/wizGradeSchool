package com.wizGrade.ObjectReository;

import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentPreviewPage { 
WebDriver driver; //global driver variable
public StudentPreviewPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath ="//a[@href='student.php']")
private WebElement addStudentlink;

@FindBy(id="index_number")
private WebElement indexNumber;

@FindBy(name="full_name")
private WebElement fullname;

@FindBy(id="i_name")
private WebElement iname;

@FindBy(name="address")
private WebElement Address;

@FindBy(id="email")
private WebElement EMAIL;

@FindBy(id="phone")
private WebElement Phone;

@FindBy(id="b_date")
private WebElement Birthdate;

@FindBy(id="g_index")
private WebElement GindexNumber;

@FindBy(id="g_full_name")
private WebElement Gfullname;

@FindBy(id="g_i_name")
private WebElement Giname;

@FindBy(id="g_address")
private WebElement GAddress;

@FindBy(id="g_email")
private WebElement GEMAIL;

@FindBy(id="g_phone")
private WebElement GPhone;

@FindBy(id="g_b_date")
private WebElement Gbirthdate;
public WebDriver getDriver() {
	return driver;
}

public WebElement getAddStudentlink() {
	return addStudentlink;
}

public WebElement getIndexNumber() {
	return indexNumber;
}

public WebElement getFullname() {
	return fullname;
}

public WebElement getIname() {
	return iname;
}

public WebElement getAddress() {
	return Address;
}

public WebElement getEMAIL() {
	return EMAIL;
}

public WebElement getPhone() {
	return Phone;
}

public WebElement getBirthdate() {
	return Birthdate;
}

public WebElement getGindexNumber() {
	return GindexNumber;
}

public WebElement getGfullname() {
	return Gfullname;
}

public WebElement getGiname() {
	return Giname;
}

public WebElement getGAddress() {
	return GAddress;
}

public WebElement getGEMAIL() {
	return GEMAIL;
}

public WebElement getGPhone() {
	return GPhone;
}

public WebElement getGbirthdate() {
	return Gbirthdate;
}

}
