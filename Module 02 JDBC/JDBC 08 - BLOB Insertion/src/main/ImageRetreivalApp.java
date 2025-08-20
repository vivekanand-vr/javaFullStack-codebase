package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.io.IOUtils;

import util.JdbcUtil;

/*
 * jar link ::  https://mvnrepository.com/artifact/commons-io/commons-io/2.8.0
 */
public class ImageRetreivalApp {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		int id = 4;

		try {
			connection = JdbcUtil.getJdbcConnection();

			String sqlSelectQuery = "select id,name,image from persons where id=?";
			if (connection != null)
				pstmt = connection.prepareStatement(sqlSelectQuery);

			if (pstmt != null) {
				// setting input values
				pstmt.setInt(1, id);

				// executing the query
				resultSet = pstmt.executeQuery();
			}

			if (resultSet != null) {

				// processing the resultSet
				if (resultSet.next()) 
				{
					System.out.println("ID\tNAME\tIMAGE");
					int sid = resultSet.getInt(1);
					String sname = resultSet.getString(2);
					InputStream is = resultSet.getBinaryStream(3);

					File file = new File("nitin_sir.jpg");
					FileOutputStream fos = new FileOutputStream(file);

					// copying the data from is to fos
					IOUtils.copy(is, fos);

					fos.close();
					System.out.println(sid + "\t" + sname + "\t" + file.getAbsolutePath());

				} 
				else 
				{
					System.out.println("Record not available for the given id :: " + id);
				}

			}

		} 
		catch (SQLException | IOException e) 
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
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
