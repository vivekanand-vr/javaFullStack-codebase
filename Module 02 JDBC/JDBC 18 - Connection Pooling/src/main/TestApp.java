package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

public class TestApp {

	public static void main(String[] args) throws Exception {

		// Create an object of a class which implements javax.sql.DataSource
		MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
		dataSource.setURL("jdbc:mysql:///ineuron");
		dataSource.setUser("root");
		dataSource.setPassword("root@123");

		// Getting the connection object from conenction pool
		Connection connection = dataSource.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select id,name,age,address from employees");
		System.out.println("ID\tNAME\tAGE\tADDRESS");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3) + "\t"
					+ resultSet.getString(4));
		}
		
		// sending the connection object back to connection pool
		connection.close();
	}

}
