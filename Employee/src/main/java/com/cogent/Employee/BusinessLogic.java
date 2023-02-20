package com.cogent.Employee;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BusinessLogic {
	
	Connection conn = null;

	// Insert
	void createEmployee() throws SQLException {
		conn = ConnectToDB.connectSetUp();
		PreparedStatement stmt = conn
				.prepareStatement("insert into Employee (EmpID, EmpName, EmpSalary) values(?,?,?)");
		stmt.setInt(1, 111);// 1 specifies the first parameter in the query
		stmt.setString(2, "Abhinav Umat");
		stmt.setFloat(3, 65.000f);
		int i = stmt.executeUpdate();
		System.out.println(i + " records inserted");

	}

	// Select
	void readEmployee() throws SQLException {
		conn = ConnectToDB.connectSetUp();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");

		while (rs.next()) {
			// Display values
			System.out.print("EmpID: " + rs.getInt("EmpID"));
			System.out.print(", EmpName: " + rs.getString("EmpName"));
			System.out.println(", EmpSalary: " + rs.getFloat("EmpSalary"));
		}
	}

	// update
	void updateEmployee() throws SQLException {
		conn = ConnectToDB.connectSetUp();
		PreparedStatement stmt = conn
				.prepareStatement("update Employee set EmpName = ? where EmpID = ?");
		stmt.setString(1, "Ankit Batra");// 1 specifies the first parameter in the query
		stmt.setInt(2, 111);
		int j = stmt.executeUpdate();
		System.out.println(j + " records updated");

	}

	// delete
	void deleteEmployee() throws SQLException {
		conn = ConnectToDB.connectSetUp();
		PreparedStatement stmt = conn.prepareStatement("delete from Employee where EmpID = ?");
		stmt.setInt(1, 111);
		int k = stmt.executeUpdate();
		System.out.println(k + " records deleted");

	}

}
