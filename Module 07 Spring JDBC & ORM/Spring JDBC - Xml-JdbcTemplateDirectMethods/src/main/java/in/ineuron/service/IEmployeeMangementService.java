package in.ineuron.service;

import java.util.List;
import java.util.Map;

public interface IEmployeeMangementService {
	public int fetchEmpsCount();
	public String getEmployeeNameByNo(int eno);
	public Map<String,Object> getEmployeeDetailsByNo(int eno);
	public List<Map<String,Object>> getEmployeeDeatilsByDesignation(String desg1,String desg2);
	public int insertEmp(String ename,int eage,String eaddress,String desg,int salary);
	public int addBonusToEmpByDesg(String desg,int bonus);
}
