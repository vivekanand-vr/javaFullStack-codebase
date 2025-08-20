package in.ineuron.service;

import java.util.List;
import java.util.Map;

import in.ineuron.dao.IEmployeeDAO;

public class EmloyeeMgmtServiceImpl implements IEmployeeMangementService {

	private IEmployeeDAO dao;

	public EmloyeeMgmtServiceImpl(IEmployeeDAO dao) {
		this.dao = dao;
	}

	@Override
	public int fetchEmpsCount() {
		return dao.getEmpsCount();
	}

	@Override
	public String getEmployeeNameByNo(int eno) {
		return dao.getEmployeeNameByNo(eno);
	}

	@Override
	public Map<String, Object> getEmployeeDetailsByNo(int eno) {
		return dao.getEmployeeDetailsByNo(eno);
	}

	@Override
	public List<Map<String, Object>> getEmployeeDeatilsByDesignation(String desg1, String desg2) {
		return dao.getEmployeeDeatilsByDesignation(desg1, desg2);
	}

	@Override
	public int insertEmp(String ename, int eage, String eaddress, String desg, int salary) {
		return dao.insertEmp(ename, eage, eaddress, desg, salary);
	}

	@Override
	public int addBonusToEmpByDesg(String desg, int bonus) {
		return dao.addBonusToEmpByDesg(desg, bonus);
	}
}
