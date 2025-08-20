package in.ineuron.dao;

import java.util.List;
import java.util.Map;

public interface IEmployeeDAO {
	public int getEmpsCount();
	public String getEmployeeNameByNo(int eno);
	public Map<String,Object> getEmployeeDetailsByNo(int eno);
	public List<Map<String,Object>> getEmployeeDeatilsByDesignation(String desg1,String desg2);
	public int insertEmp(String ename,int eage,String eaddress,String desg,int salary);
	public int addBonusToEmpByDesg(String desg,int bonus);
}
