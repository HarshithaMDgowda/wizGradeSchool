package com.wizGrade.GenericFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.wizGrade.ObjectReository.HomePage;
import com.wizGrade.ObjectReository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver sDriver;
	public WebDriver driver = null;

	// create an Object to Utility*/
	public WebDriverUtility wlib = new WebDriverUtility();
	public FileUtility flib = new FileUtility();
	public JavaUtility jlib = new JavaUtility();
	public ExcelUtility elib = new ExcelUtility();

	@BeforeSuite(groups = { "smoke", "regression" })
	public void configBS() {
		System.out.println("connect to database");
	}

	// @Parameters("browser")
	@BeforeClass(groups = { "smoke", "regression" })
	public void configBC() throws Throwable {
		String browser = flib.getPropertyKeyValue("browser");
		System.out.println(browser);
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		System.out.println("launch the browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		String URL = flib.getPropertyKeyValue("url");
		System.out.println(URL);
		driver.get(URL);
		sDriver = driver;
	}

	@BeforeMethod(groups = { "smoke", "regression" })
	public void configBM() throws Throwable {
		// common data

		String Adminemailid = flib.getPropertyKeyValue("adminemailid");
		String Adminpassword = flib.getPropertyKeyValue("adminpassword");

		// login to app
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(Adminemailid, Adminpassword);
	}

	@AfterMethod(groups = { "smoke", "regression" })
	public void configAM() throws InterruptedException {
		// logout
		//HomePage hp = new HomePage(driver);
		//hp.SignOut();
		 Thread.sleep(6000);
		  
		  	HomePage h1=new HomePage(driver);
		  h1.getIngeniousDeveloper1().click();
			h1.getSignout().click();
			System.out.println("logout");
	}

	@AfterClass(groups = { "smoke", "regression" })
	public void configAc() {
		System.out.println("close the browser");
		driver.quit();
	}

	@AfterSuite(groups = { "smoke", "regression" })
	public void configAS() {
		System.out.println("close db");
	}
}
