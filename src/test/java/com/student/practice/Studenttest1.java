package com.student.practice;

import org.testng.annotations.Test;

public class Studenttest1 {
	@Test(priority = 1)
	public void createStudenttest() {
		System.out.println("createstudent");
	}
@Test(priority = 3)
public void editStudentTest() {
	System.out.println("edit student");
}
@Test(priority = 2)
public void deletestudenttesttest() {
	System.out.println("delete student");

}
}