package in.ineuron.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SQLInjectionSolutionApp {

	public static void main(String[] args) throws Exception {

		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "root123");

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the userName :: ");
		String uname = scanner.next();

		System.out.print("Enter the password :: ");
		String upwd = scanner.next();

		String sqlSelectQuery = "select count(*) from users where name =? and password = ? ";
		PreparedStatement pstmt = connection.prepareStatement(sqlSelectQuery);
		System.out.println(sqlSelectQuery);

		pstmt.setString(1, uname);
		pstmt.setString(2, upwd);

		ResultSet resultSet = pstmt.executeQuery();
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
