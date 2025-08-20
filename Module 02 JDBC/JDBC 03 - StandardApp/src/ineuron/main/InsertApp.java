package ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ineuron.util.JdbcUtil;

/**
 * @author nitin
 * @Company iNeuron
 * @see www.ineuron.ai
 *
 */
public class InsertApp {

	public static void main(String[] args) 
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				statement = connection.createStatement();

			if (statement != null)
				resultSet = statement.executeQuery("select sid,sname,sage,saddress,sgender from student");

			if (resultSet != null) {
				System.out.printf("%-2s%14s%12s%15s%15s","SID","SNAME","SAGE","SADDRESS","SGENDER");
				System.out.println();
				while (resultSet.next()) {
					System.out.printf("%2d%15s%12d%15s%15s", resultSet.getInt(1), resultSet.getString(2),
							resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
					System.out.println();
				}
			}
		}
		
		catch(IOException ie)
		{
			ie.printStackTrace();
		}
		catch (SQLException se)
		{
			se.printStackTrace();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try {
				JdbcUtil.cleanUp(connection, statement, resultSet);
				System.out.println("closing the resources...");
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}

	}
}
