package com.wizGradeschoolapp.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDBExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//step 1=create object for driver 
				Driver driverRef=new Driver();
				Connection con = null;
				
				
				//step 2=Register the driver
				DriverManager.registerDriver(driverRef);
				
		
			
				//step3 establish the connection-provide database name
				
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wizGrade", "root", "root");
				
				//step4 create statement
				Statement state = con.createStatement();
				
				//step5 execute the query
				String query = "insert into studentdetails values(20,'harshitha',914866349);";
				int result = state.executeUpdate(query);
				System.out.println(result);
				
				//step 6 validate
				if(result==1)
				{
					System.out.println("data added successfully");
						}
				else {
					System.out.println("data not added");
					
				}
				//step 7 closed connection 
				con.close();
				System.out.println("connection closed");
				}	}




