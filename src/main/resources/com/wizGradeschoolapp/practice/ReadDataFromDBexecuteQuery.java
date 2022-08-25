package com.wizGradeschoolapp.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDBexecuteQuery {
public static void main(String[] args) throws SQLException {
	//step 1 create object for driver
	Driver driverRef=new Driver();
Connection con=null;
	//step 2 register driver
	DriverManager.registerDriver(driverRef);
	  
	
	//step3 establish the connection
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wizGrade", "root", "root");
	
	//step4 create statement
	
	Statement statement=con.createStatement();
	
	//step4 execute the query 
String query= "select * from studentdetails;";
String expData="harshitha";
ResultSet result = statement.executeQuery(query);
boolean flag=false;
while(result.next())
{
	String actData=result.getString(2);
	if(actData.equalsIgnoreCase(expData))
	{
		System.out.println(actData);
		flag = true;
		break;
	}
	
}
if(flag) {
	System.out.println("data present");
}
else {
	System.out.println("data not present");
	}
//close connection
con.close();
}
}
