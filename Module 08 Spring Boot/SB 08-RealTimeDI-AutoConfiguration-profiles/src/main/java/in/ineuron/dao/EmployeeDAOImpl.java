package in.ineuron.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import in.ineuron.bo.EmployeeBO;

@Component("empDao")
@Profile({"dev","uat"})
public class EmployeeDAOImpl implements IEmployeeDao {

	private static final String GET_EMPS_BY_DEGS = "SELECT EMPNO,ENAME,JOB,SAL,DEPTNO,MGR FROM EMP  WHERE JOB IN";

	@Autowired
	private DataSource ds;

	@Override
	public List<EmployeeBO> getEmpsByDesg(String cond) throws Exception {
		List<EmployeeBO> listBO = null;
		System.out.println("DataSource obj class name::" + ds.getClass());
		try (Connection con = ds.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(GET_EMPS_BY_DEGS + cond + " ORDER BY JOB");) {

			// convert RS object records to List of BO class object
			listBO = new ArrayList<EmployeeBO>();

			EmployeeBO bo = null;
			while (rs.next()) {
				// copy each record of RS to a object of EmployeeBO class
				bo = new EmployeeBO();
				bo.setEmpNo(rs.getInt(1));
				bo.setEmpName(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getDouble(4));
				bo.setDeptNo(rs.getInt(5));
				bo.setMgrNo(rs.getInt(6));
				// add each object of EmpoyeeBO to List Collection
				listBO.add(bo);
			}
		} catch (SQLException se) {
			se.printStackTrace();
			throw se; // for Exception propagation
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return listBO;
	}
}
