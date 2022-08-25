package com.wizGrade.GenericFiles;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listenerimplementation implements ITestListener{
public void onTestFailure(ITestResult result) {
	String tcName = result.getMethod().getMethodName();
	EventFiringWebDriver e=new EventFiringWebDriver(BaseClass.sDriver);
	File src = e.getScreenshotAs(OutputType.FILE);
	File dst = new File("./photos/"+tcName+".png");
	try {
	FileUtils.copyFile(src, dst);
		
	} catch (Exception e1) {
		// TODO: handle exception
		e1.printStackTrace();
	}
}
}
