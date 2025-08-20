package in.ineuron.dao;

import java.util.List;

import in.ineuron.bo.EmployeeBO;

public interface IEmployeeDao {
	public  List<EmployeeBO>  getEmpsByDesg(String cond)throws Exception;
}
