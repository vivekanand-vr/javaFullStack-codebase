package in.ineuron.main;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class SelectApp {

	public static void main(String[] args) throws Exception {

		RowSetFactory rsf = RowSetProvider.newFactory();
		JdbcRowSet jrs = rsf.createJdbcRowSet();// same as resultSet(connected),but it is scrollable and updatable.

		// setting url,username,password and getting connection object..
		jrs.setUrl("jdbc:mysql:///octbatch");
		jrs.setUsername("root");
		jrs.setPassword("root123");

		// setting a command for execution
		jrs.setCommand("select id,name,age,address from student");
		jrs.execute();

		System.out.println("Retreiveing the records in forward direction...");
		System.out.println("ID\tNAME\tAGE\tADDRESS");
		while (jrs.next()) {
			System.out
					.println(jrs.getInt(1) + "\t" + jrs.getString(2) + "\t" + jrs.getInt(3) + "\t" + jrs.getString(4));
		}
		System.out.println();

		System.out.println("Retreiveing the records in backward direction...");
		System.out.println("ID\tNAME\tAGE\tADDRESS");
		while (jrs.previous()) {
			System.out
					.println(jrs.getInt(1) + "\t" + jrs.getString(2) + "\t" + jrs.getInt(3) + "\t" + jrs.getString(4));
		}

		System.out.println();

		// accessing the record randomly
		jrs.absolute(4);
		System.out.println(jrs.getInt(1) + "\t" + jrs.getString(2) + "\t" + jrs.getInt(3) + "\t" + jrs.getString(4));

		jrs.relative(-2);
		System.out.println(jrs.getInt(1) + "\t" + jrs.getString(2) + "\t" + jrs.getInt(3) + "\t" + jrs.getString(4));

	}
}
