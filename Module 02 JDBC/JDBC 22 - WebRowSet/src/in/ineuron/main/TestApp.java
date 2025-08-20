package in.ineuron.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class TestApp {
	public static void main(String[] args) throws Exception {

		Connection connection = DriverManager.getConnection("jdbc:mysql:///octbatch", "root", "root123");
		Statement stmt = connection.createStatement();
		ResultSet resultSet = stmt.executeQuery("select id,name,age,address,salary from student");
		
		RowSetFactory rsf = RowSetProvider.newFactory();
		CachedRowSet crs = rsf.createCachedRowSet();//disconnected rowset
		crs.populate(resultSet);
		
		connection.close();//Operation not allowed after ResultSet closed
		System.out.println("ID\tNAME\tAGE\tADDRESS\tSALARY");
		while (crs.next()) {
			System.out.println(crs.getInt(1) + "\t" + crs.getString(2) + "\t" + crs.getInt(3) + "\t"
					+ crs.getString(4) + "\t" + crs.getInt(5));
		}

	}
}
