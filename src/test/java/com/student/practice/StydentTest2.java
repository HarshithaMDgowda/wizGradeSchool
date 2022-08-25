package com.student.practice;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.Test;

import com.wizGrade.Student.createSubjecttest;

public class StydentTest2 {
	@Test
	public void createStudenttest() {
		System.out.println("createstudent");
	}
@Test(dependsOnMethods = "createSubjecttest")
public void editStudentTest() {
	System.out.println("edit student");
}
@Test(dependsOnMethods = "editStudentTest")
public void deletestudenttesttest() {
	System.out.println("delete student");
	 }
@Test(dependsOnMethods = "deletestudenttesttest")
	public void Activestudenttest() {
	System.out.println("active student");
}
}
