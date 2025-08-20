package in.ineuron.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.ineuron.bo.EmployeeBO;

@Repository(value = "dao")
public class EmployeeDaoImpl implements IEmployeeDAO {

	private static final String SQL_INSERT_QUERY = "";

	static {
		System.out.println("EmployeeDaoImpl.class file is loading...");
	}

	public EmployeeDaoImpl() {
		System.out.println("EmployeeDaoImpl :: Zero param constructor...");
	}

	@Autowired
	private DataSource datasource;

	@Override
	public EmployeeBO save(EmployeeBO bo) {
		try(Connection connection = datasource.getConnection(); PreparedStatement pstmt=connection.prepareStatement(SQL_INSERT_QUERY)){
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String toString() {
		return "EmployeeDaoImpl [datasource=" + datasource + "]";
	}

}
