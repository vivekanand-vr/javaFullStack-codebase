package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import util.JdbcUtil;

/**
 * @author nitin
 * @version JDK1.8 Company : www.ineuron.ai
 */
public class BatchUpdateUsingPreparedStatement {

	public static void main(String[] args) {

		// Resources used
		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner scanner = null;

		try {
			connection = JdbcUtil.getJdbcConnection();

			String sqlInsertQuery = "insert into employees(`name`,`age`,`address`) values(?,?,?)";
			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);

			if (pstmt != null) {
				scanner = new Scanner(System.in);
				
				while (true) {

					System.out.print("Enter the name :: ");
					String name = scanner.next();
					System.out.print("Enter the age:: ");
					Integer age = scanner.nextInt();
					System.out.print("Enter the address :: ");
					String address = scanner.next();

					pstmt.setString(1, name);
					pstmt.setInt(2, age);
					pstmt.setString(3, address);

					// Query added to batch file
					pstmt.addBatch();

					System.out.print("Do u want to insert one more record[YES/NO]:: ");
					String option = scanner.next();

					if (option.equalsIgnoreCase("no")) {
						break;
					}

				}

				// Executing the queries present in batch file
				pstmt.executeBatch();

				System.out.println("Records inserted succesfully....");

			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				JdbcUtil.cleanUp(connection, pstmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			scanner.close();
		}

	}

}
