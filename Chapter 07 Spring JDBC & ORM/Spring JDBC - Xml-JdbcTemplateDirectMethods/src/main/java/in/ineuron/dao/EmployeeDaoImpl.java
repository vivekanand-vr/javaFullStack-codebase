package in.ineuron.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDaoImpl implements IEmployeeDAO {

	private static final String SQL_SELECT_QUERY = "SELECT count(*) from Employees";
	private static final String SQL_SELECT_QUERY_BY_ID = "select ename from Employees where id=?";
	private static final String GET_EMPLOYEE_BY_No = "select id,ename,eage,eaddress,desg,esalary from employees where id=?";
	private static final String GET_EMPLOYEE_BY_DESG = "select id,ename,eage,eaddress,desg,esalary from employees where desg in (?,?) order by esalary";
	private static final String INSERT_EMPLOYEE = "insert into Employees(`ename`,`eage`,`eaddress`,`esalary`, `desg`) values(?,?,?,?,?)";
	private static final String ADD_BONUS_EMP_BY_DESG = "update Employees set esalary=esalary+? where desg=?";
	
	
	private JdbcTemplate jdbcTemplate;

	
	public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int getEmpsCount() {
		return jdbcTemplate.queryForObject(SQL_SELECT_QUERY, Integer.class);
	}

	@Override
	public String getEmployeeNameByNo(int eno) {
		return jdbcTemplate.queryForObject(SQL_SELECT_QUERY_BY_ID, String.class,eno);
	}

	@Override
	public Map<String, Object> getEmployeeDetailsByNo(int eno) {
		/*
		 * Gets the data in key and value pairs , eno is passed for '?' this place holder
		 */
		Map<String,Object> map = jdbcTemplate.queryForMap(GET_EMPLOYEE_BY_No,eno);
		return map;
	}

	@Override
	public List<Map<String, Object>> getEmployeeDeatilsByDesignation(String desg1, String desg2) {
		List<Map<String, Object>> empRecords = jdbcTemplate.queryForList(GET_EMPLOYEE_BY_DESG, desg1,desg2);
		return empRecords;
	}

	@Override
	public int insertEmp(String ename, int eage, String eaddress, String desg, int esalary) {
		return jdbcTemplate.update(INSERT_EMPLOYEE, ename,eage,eaddress, esalary, desg);
	}

	@Override
	public int addBonusToEmpByDesg(String desg, int bonus) {
		return jdbcTemplate.update(ADD_BONUS_EMP_BY_DESG,bonus,desg);
	}
}
