package main;

import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class InsertApp {

	public static void main(String[] args) throws Exception {

		RowSetFactory rsf = RowSetProvider.newFactory();
		CachedRowSet crs = rsf.createCachedRowSet();// same as resultSet(connected),but it is scrollable and updatable.

		// setting url,username,password and getting connection object..
		crs.setUrl("jdbc:mysql:///octbatch");
		crs.setUsername("root");
		crs.setPassword("root123");
		

		// setting a command for execution
		crs.setCommand("select id,name,age,address,salary from student");
		crs.execute();

		Scanner scanner = new Scanner(System.in);
		while (true) {
			
			System.out.print("Enter the id::");
			Integer id = scanner.nextInt();
			
			System.out.print("Enter the name::");
			String name = scanner.next();

			System.out.print("Enter the age::");
			Integer age = scanner.nextInt();

			System.out.print("Enter the address::");
			String address = scanner.next();

			System.out.print("Enter the salary::");
			Integer salary = scanner.nextInt();

			crs.moveToInsertRow();
			
			crs.updateInt(1, id);
			crs.updateString(2, name);
			crs.updateInt(3, age);
			crs.updateString(4, address);
			crs.updateInt(5, salary);
			
			crs.insertRow();


			System.out.println("Record inserted succesfully.....");
			System.out.print("Do u want to insert one more record [Yes/No]::  ");
			String option = scanner.next();
			if (option.equalsIgnoreCase("No")) {
				break;
			}

			crs.moveToCurrentRow();
			crs.acceptChanges();//even if the connection gets disconnected the record should be added

		}
		scanner.close();
		crs.close();

	}
}
