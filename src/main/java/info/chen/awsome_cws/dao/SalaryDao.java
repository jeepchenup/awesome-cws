package info.chen.awsome_cws.dao;


import info.chen.awsome_cws.entity.Employee;
import info.chen.awsome_cws.entity.composite_id.SalaryID;

public interface SalaryDao {

	Employee getEmpBySalaryID(SalaryID salaryID);
	
}
