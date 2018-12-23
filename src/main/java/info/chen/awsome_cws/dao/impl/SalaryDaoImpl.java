package info.chen.awsome_cws.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import info.chen.awsome_cws.dao.AbstractDao;
import info.chen.awsome_cws.dao.SalaryDao;
import info.chen.awsome_cws.entity.Employee;
import info.chen.awsome_cws.entity.Salary;
import info.chen.awsome_cws.entity.composite_id.SalaryID;

@Repository
@Transactional
public class SalaryDaoImpl extends AbstractDao<Salary> implements SalaryDao {

	@Override
	public Employee getEmpBySalaryID(SalaryID salaryID) {
		Salary salary = (Salary) getSession().get(Salary.class, salaryID);
		return salary.getEmployee();
	}

}
