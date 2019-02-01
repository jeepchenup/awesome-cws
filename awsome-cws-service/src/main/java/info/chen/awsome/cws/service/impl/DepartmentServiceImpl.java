package info.chen.awsome.cws.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.chen.awsome.cws.persist.dao.DepartmentDao;
import info.chen.awsome.cws.persist.entity.Department;
import info.chen.awsome.cws.persist.entity.Employee;
import info.chen.awsome.cws.persist.exception.DepartmentException;
import info.chen.awsome.cws.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public Department getDepartmentById(String deptNo) throws DepartmentException{
		return departmentDao.getDepartmentById(deptNo);
	}

	@Override
	public List<Department> getAllDepartment() throws DepartmentException {
		return departmentDao.getAllDepartment();
	}

	@Override
	public void addDepartment(Department department) throws DepartmentException {
		departmentDao.addDepartment(department);
	}

	@Override
	public void updateDepartment(Department department) throws DepartmentException {
		departmentDao.updateDepartment(department);
	}

	@Override
	public void deleteDepartmentByID(String deptNo) throws DepartmentException {
		Department department = departmentDao.getDepartmentById(deptNo);
		departmentDao.deleteDepartment(department);
	}

	@Override
	public Set<Employee> getEmployeesByDepartmentID(String deptNo) throws DepartmentException {
		return departmentDao.getEmployeesByDepartmentID(deptNo);
	}

}
