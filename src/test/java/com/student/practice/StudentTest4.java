package com.student.practice;

import org.testng.annotations.Test;

public class StudentTest4 {
	@Test(invocationCount = 2)
	public void createStudenttest() {
		System.out.println("createstudent");
	}
@Test(invocationCount = 4)
public void editStudentTest() {
	System.out.println("edit student");
}
@Test
public void deletestudenttesttest() {
	System.out.println("delete student");
	}

}
