package in.ineuron.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.io.IOUtils;

import in.ineuron.util.JdbcUtil;

/*
 * jar link ::  https://mvnrepository.com/artifact/commons-io/commons-io/2.8.0
 */
public class ClobRetreivalApp {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		int id = 1;

		try {
			connection = JdbcUtil.getJdbcConnection();

			String sqlSelectQuery = "select id,name,history from cities where id=?";
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
				if (resultSet.next()) {
					System.out.println("ID\tNAME\t\tHISTORY");
					int sid = resultSet.getInt(1);
					String sname = resultSet.getString(2);
					Reader reader = resultSet.getCharacterStream(3);

					File file = new File("history_copied.txt");
					FileWriter writer = new FileWriter(file);

					// copying the data from is to fos
					IOUtils.copy(reader, writer);

					writer.close();
					System.out.println(sid + "\t" + sname + "\t" + file.getAbsolutePath());

				} else {
					System.out.println("Record not available for the given id :: " + id);
				}

			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
