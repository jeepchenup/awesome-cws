package info.chen.awsome.cws.persist.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import info.chen.awsome.cws.persist.dao.AbstractDao;
import info.chen.awsome.cws.persist.dao.SalaryDao;
import info.chen.awsome.cws.persist.entity.Salary;
import info.chen.awsome.cws.persist.exception.SalaryException;

@Repository("salaryDao")
public class SalaryDaoImpl extends AbstractDao<Salary> implements SalaryDao {
	
	private static Logger LOGGER = LoggerFactory.getLogger(SalaryDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<Salary> getSalariesByEmployeeID(Integer id) throws SalaryException{
		LOGGER.info("DAO -> Get employee: {}'s salaries", id);
		Query query = getQuery("FROM Salary WHERE emp_no=:emp_no");
		query.setInteger("emp_no", id);
		return query.list();
	}

	@Override
	public void addSalary(Salary salary) throws SalaryException {
		Integer empId = salary.getSalaryID().getEmpNo();
		LOGGER.info("DAO -> Add employee: {}'s salary", empId);
		
		Salary latestSalary = getLatestSalary(empId);
		if(latestSalary != null) {
			salary.getSalaryID().setFromDate(latestSalary.getToDate());
		}
		
		persistEntity(salary);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Salary getLatestSalary(Integer id) throws SalaryException {
		LOGGER.info("DAO -> Get the {}'s latest salary.", id);
		
		Query query = getQuery("FROM Salary WHERE emp_no=:empNo ORDER BY to_date desc");
		query.setInteger("empNo", id);
		List<Salary> salaries = query.list();
		
		return salaries.size() == 0 ? null : salaries.get(0);
	}

}
