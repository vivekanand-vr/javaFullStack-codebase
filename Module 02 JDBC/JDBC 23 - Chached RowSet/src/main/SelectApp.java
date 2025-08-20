package main;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class SelectApp {

	public static void main(String[] args) throws Exception {

		RowSetFactory rsf = RowSetProvider.newFactory();
		CachedRowSet crs = rsf.createCachedRowSet();// same as resultSet(connected),but it is scrollable and updatable.

		// setting url,username,password and getting connection object..
		crs.setUrl("jdbc:mysql:///octbatch");
		crs.setUsername("root");
		crs.setPassword("root123");

		// setting a command for execution
		crs.setCommand("select id,name,age,address,salary from student");
		crs.execute();

		System.out.println("Retreiveing the records in forward direction...");
		System.out.println("ID\tNAME\tAGE\tADDRESS\tSALARY");
		while (crs.next()) {
			System.out.println(crs.getInt(1) + "\t" + crs.getString(2) + "\t" + crs.getInt(3) + "\t" + crs.getString(4)
					+ "\t" + crs.getInt(5));
		}
		System.out.println();

		System.out.println("Retreiveing the records in backward direction...");
		System.out.println("ID\tNAME\tAGE\tADDRESS");
		while (crs.previous()) {
			System.out.println(crs.getInt(1) + "\t" + crs.getString(2) + "\t" + crs.getInt(3) + "\t" + crs.getString(4)
					+ "\t" + crs.getInt(5));
		}

		System.out.println();

		// accessing the record randomly
		crs.absolute(2);
		System.out.println(crs.getInt(1) + "\t" + crs.getString(2) + "\t" + crs.getInt(3) + "\t" + crs.getString(4)
				+ "\t" + crs.getInt(5));

		crs.relative(-1);
		System.out.println(crs.getInt(1) + "\t" + crs.getString(2) + "\t" + crs.getInt(3) + "\t" + crs.getString(4)
				+ "\t" + crs.getInt(5));

	}
}
