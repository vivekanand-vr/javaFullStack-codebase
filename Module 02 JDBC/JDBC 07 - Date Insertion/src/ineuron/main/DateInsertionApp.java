package ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import ineuron.util.JdbcUtil;

/**
 * @author nitin
 * @version JDK1.8
 * Company : www.ineuron.ai
 */

public class DateInsertionApp {

	public static void main(String[] args) {

		//Resources used
		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner scanner = null;
		
		//variables used
		java.sql.Date sqlDob = null;
		java.sql.Date sqlDom = null;

		String name = null;
		String dob = null;
		String dom = null;

		try {
			connection = JdbcUtil.getJdbcConnection();

			String sqlInsertQuery = "insert into users values(?,?,?)";
			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);

			if (pstmt != null) {
				scanner = new Scanner(System.in);

				// collecting the inputs
				if (scanner != null) {
					System.out.print("Enter the username :: ");
					name = scanner.next();

					System.out.print("Enter the dob(MM-dd-yyyy) :: ");
					dob = scanner.next();

					System.out.print("Enter the dom(yyyy-MM-dd) :: ");
					dom = scanner.next();
				}

				if (dob != null) {
					// Conversion of String to sqlDate
					SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
					java.util.Date uDate = sdf.parse(dob);

					long value = uDate.getTime();
					sqlDob = new java.sql.Date(value);
				}

				if (dom != null)
					sqlDom = java.sql.Date.valueOf(dom);

				// Set the input values to Query
				pstmt.setString(1, name);
				pstmt.setDate(2, sqlDob);
				pstmt.setDate(3, sqlDom);

				// execute the query
				int rowAffected = pstmt.executeUpdate();
				System.out.println("No of rows inserted inserted is :: " + rowAffected);

			}

		} 
		catch (SQLException | IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		finally 
		{

			try {
				JdbcUtil.cleanUp(connection, pstmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			scanner.close();
		}

	}

}
