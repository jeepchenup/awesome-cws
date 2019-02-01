package info.chen.awsome.cws.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.chen.awsome.cws.persist.dao.EmployeeDao;
import info.chen.awsome.cws.persist.entity.Department;
import info.chen.awsome.cws.persist.entity.Employee;
import info.chen.awsome.cws.persist.exception.EmployeeException;
import info.chen.awsome.cws.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Employee getEmployeeByEmpID(Integer id) throws EmployeeException {
		return employeeDao.getEmployeeByEmpID(id);
	}

	@Override
	public List<Employee> getAllEmployees(Integer limitNum) throws EmployeeException {
		return employeeDao.getAllEmployees(limitNum);
	}

	@Override
	public void addEmployee(Employee employee) throws EmployeeException {
		employeeDao.addEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) throws EmployeeException {
		employeeDao.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(Integer id) throws EmployeeException {
		Employee employee = employeeDao.getEmployeeByEmpID(id);
		if(employee == null) 
			throw new EmployeeException();
		employeeDao.deleteEmployee(employee);
	}

	@Override
	public Set<Department> getDepartmentsByEmployeeID(Integer id) throws EmployeeException {
		return employeeDao.getDepartmentsByEmployeeID(id);
	}

}
