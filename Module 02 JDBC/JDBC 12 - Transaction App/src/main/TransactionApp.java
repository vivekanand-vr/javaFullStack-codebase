package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import util.JdbcUtil;

/**
 * @author nitin
 * @version JDK1.8 Company : www.ineuron.ai
 */
public class TransactionApp {

	public static void main(String[] args) {

		// Resources used
		Connection connection = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		Scanner scanner = null;
		ResultSet rs = null;

		try {
			System.out.println("Data before transaction...");
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null)
				stmt = connection.createStatement();

			if (stmt != null)
				resultSet = stmt.executeQuery("select name,balance from accounts");

			if (resultSet != null) {
				System.out.println("NAME\tBALANCE");
				while (resultSet.next()) {
					System.out.println(resultSet.getString(1) + "\t" + resultSet.getInt(2));
				}
			}

			// Transaction begins
			System.out.println("\n Transaction begins.....");
			connection.setAutoCommit(false);

			// Prepare the operations as a single unit
			stmt.executeUpdate("update accounts set balance = balance-2000 where name = 'sachin'");
			stmt.executeUpdate("update accounts set balance = balance+2000 where name = 'dhoni'");
			System.out.print("Can u please confirm the transaction  of 2000INR...[YES/NO]");
			scanner = new Scanner(System.in);
			String option = scanner.next();
			if (option.equalsIgnoreCase("yes")) {
				connection.commit();
			} else {
				connection.rollback();
			}

			System.out.println("\nData after transaction....");
			rs = stmt.executeQuery("select name,balance from accounts");
			if (rs != null) {
				System.out.println("NAME\tBALANCE");
				while (rs.next()) {
					System.out.println(rs.getString(1) + "\t" + rs.getInt(2));
				}
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				JdbcUtil.cleanUp(connection, stmt, resultSet);
				JdbcUtil.cleanUp(null, null, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
