package in.ineuron.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectApp {
	
	public static void main(String []a) throws SQLException {
		
	String url = "jdbc:mysql:///iNeuron";
	String user = "root";
	String password = "root@123";
	Connection connection = DriverManager.getConnection(url, user, password);
	Statement statement  = connection.createStatement();
	System.out.println("statement object created");
	
	String sqlQuery = "select sid, sname, sage, saddress from student";
	ResultSet result = statement.executeQuery(sqlQuery);
	System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
	
	while(result.next()){
		int sid = result.getInt("sid");
		String name = result.getString("sname");
		int sage = result.getInt("sage");
		String address = result.getNString("saddress");
		System.out.println(sid + "\t" + name + "\t" + sage + "\t" + address);
	}
	
	result.close();
	statement.close();
	connection.close();
	}
}
