package in.ineuron.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.ineuron.dto.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {

	private static final String SQLINSERTQUERY = "insert into employee(eid,ename,eage,email,mobile) values(?,?,?,?,?)";

	@Override
	public String insert(Employee employee) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		String status = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql:///ineuron", "root", "root@123");
			if (connection != null)
				pstmt = connection.prepareStatement(SQLINSERTQUERY);
			if (pstmt != null) {
				pstmt.setString(1, employee.getEid());
				pstmt.setString(2, employee.getEname());
				pstmt.setInt(3, employee.getEage());
				pstmt.setString(4, employee.getEmail());
				pstmt.setString(5, employee.getMobile());

				int rowCount = pstmt.executeUpdate();
				if (rowCount == 1) {
					status = "success";
				} else {
					status = "failure";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return status;
	}

}
