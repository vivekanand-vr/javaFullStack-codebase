package in.ineuron.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC4.X autoloading feature is enabled.
public class UpdateApp {

	public static void main(String[] args) throws SQLException {

		// Step2. Establish the Connection
		String url = "jdbc:mysql:///ineuron";
		String user = "root";
		String password = "root@123";
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println("CONNECTION object created...");

		// Step3. Create statement Object and send the Query
		Statement statement = connection.createStatement();
		System.out.println("STATEMENT object created...");

		// Step4. Execute the Query
		String sqlUpdateQuery = "update student set saddress = 'MI' where sid = 5";
		int rowAffected = statement.executeUpdate(sqlUpdateQuery);
		System.out.println("No of rows updated is :: " + rowAffected);

		// Step6. Close the resources
		statement.close();
		connection.close();
		System.out.println("Closing the resources...");

	}
}
