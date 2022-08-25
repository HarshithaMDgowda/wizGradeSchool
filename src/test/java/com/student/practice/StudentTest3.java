package com.student.practice;

import org.testng.annotations.Test;

public class StudentTest3 {
	public class Studenttest1 {
		@Test(priority = 1)
		public void createStudenttest() {
			System.out.println("createstudent");
		}
	@Test(invocationCount = 3)
	public void editStudentTest() {
		System.out.println("edit student");
	}
	@Test(priority = 2)
	public void deletestudenttesttest() {
		System.out.println("delete student");

	}
}
}