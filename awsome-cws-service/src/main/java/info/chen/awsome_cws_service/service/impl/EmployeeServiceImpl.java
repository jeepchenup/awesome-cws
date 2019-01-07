package info.chen.awsome_cws_service.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.chen.awsome_cws_persist.dao.EmployeeDao;
import info.chen.awsome_cws_persist.entity.Department;
import info.chen.awsome_cws_persist.entity.Employee;
import info.chen.awsome_cws_service.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Employee getEmployeeByEmpID(Integer id) {
		return employeeDao.getEmployeeByEmpID(id);
	}

	@Override
	public List<Employee> getAllEmployees(Integer limitNum) {
		return employeeDao.getAllEmployees(limitNum);
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeDao.deleteEmployee(employee);
	}

	@Override
	public Set<Department> getDepartmentsByEmployeeID(Integer id) {
		return employeeDao.getDepartmentsByEmployeeID(id);
	}
	

}
