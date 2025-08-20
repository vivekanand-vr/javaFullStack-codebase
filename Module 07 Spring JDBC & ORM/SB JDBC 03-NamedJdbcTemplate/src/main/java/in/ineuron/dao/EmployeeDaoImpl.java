package in.ineuron.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import in.ineuron.bo.EmployeeBO;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

	private static final String GET_EMPLOYEE_BY_NAME = "SELECT ENAME FROM EMPLOYEES WHERE EID=:no";
	private static final String GET_EMPLOYEE_BY_DESG = "SELECT EID,ENAME,EAGE,EADDRESS,DESG,SALARY FROM EMPLOYEES WHERE DESG IN(:desg1,:desg2,:desg3)";
	private static final String INSERT_EMPLOYEE = "INSERT INTO EMPLOYEES(`ename`,`eage`,`eaddress`,`desg`,`salary`)values(:ename,:eage,:eaddress,:desg,:salary)";

	@Autowired
	private NamedParameterJdbcTemplate template;

	@Override
	public List<EmployeeBO> fetchEmployeesByDesg(String desg1, String desg2, String desg3)
	{

		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("desg1", desg1);
		map.addValue("desg2", desg2);
		map.addValue("desg3", desg3);

		return template.query(GET_EMPLOYEE_BY_DESG, map,

				// lambda Expression of ResultSetExtractor===>extractData(ResultSet rs)
				rs -> {	List<EmployeeBO> bo = new ArrayList<EmployeeBO>();
							while (rs.next()) {
								EmployeeBO employeeBO = new EmployeeBO();
								employeeBO.setEid(rs.getInt(1));
								employeeBO.setEname(rs.getString(2));
								employeeBO.setEage(rs.getInt(3));
								employeeBO.setEaddress(rs.getString(4));
								employeeBO.setSalary(rs.getInt(6));
								employeeBO.setDesg(rs.getString(5));
								bo.add(employeeBO);
							}
							return bo;
						});
	}

	@Override
	public int registerEmployee(EmployeeBO bo) {
		BeanPropertySqlParameterSource map = new BeanPropertySqlParameterSource(bo);
		return template.update(INSERT_EMPLOYEE, map);
	}

	@Override
	public String getEmployeeByName(int no) {

		/*
		 * HashMap<String, Integer> hm = new HashMap<String, Integer>();
		 * hm.put("no",no);
		 */
		Map<String, Integer> map = Map.of("no", no);
		return template.queryForObject(GET_EMPLOYEE_BY_NAME, map, String.class);
	}

}
