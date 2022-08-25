package com.wizGradeschoolapp.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


import com.mysql.cj.jdbc.Driver;

public class ReadDataFRomDataBaseExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//step 1=create object for driver 
		Driver driverRef=new Driver();
		Connection con = null;
		
		
		//step 2=Register the driver
		DriverManager.registerDriver(driverRef);
		
		try {
	
		//step3 establish the connection-provide database name
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wizGrade", "root", "root");
		
		//step4 create statement
		Statement state = con.createStatement();
		
		//step5 execute the query
	state.executeUpdate("create table studentdetails(studentid int(5) not null unique,studentname varchar(20),phone_number int(10) not null unique);");
	System.out.println("data updated");
	}
	finally {
		//close connection
	con.close();
	System.out.println("connection closed");
	}
	

	}

}
