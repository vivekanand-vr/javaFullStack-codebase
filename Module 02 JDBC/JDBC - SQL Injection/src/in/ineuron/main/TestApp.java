package in.ineuron.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TestApp {

	public static void main(String[] args) throws Exception {

		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "root123");
		Statement statement = connection.createStatement();

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the userName :: ");
		String uname = scanner.next();

		System.out.print("Enter the password :: ");
		String upwd = scanner.next();

		String sqlSelectQuery = "select count(*) from users where name ='" + uname + "'and password ='" + upwd + "'";
		System.out.println(sqlSelectQuery);

		ResultSet resultSet = statement.executeQuery(sqlSelectQuery);
		int row = 0;
		if (resultSet.next()) {
			row = resultSet.getInt(1);
		}

		if (row == 1)
			System.out.println("valid credentials");
		else
			System.out.println("invalid credentials");

		scanner.close();
	}

}
