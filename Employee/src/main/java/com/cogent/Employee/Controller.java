package com.cogent.Employee;

import java.sql.SQLException;

public class Controller {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		BusinessLogic b1 = new BusinessLogic();
		b1.createEmployee();
		b1.updateEmployee();
		
		b1.readEmployee();
		b1.deleteEmployee();

	}

}
