package info.chen.awsome.cws.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.chen.awsome.cws.persist.dao.DepartmentDao;
import info.chen.awsome.cws.persist.entity.Department;
import info.chen.awsome.cws.persist.entity.Employee;
import info.chen.awsome.cws.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public Department getDepartmentById(String deptNo) {
		return departmentDao.getDepartmentById(deptNo);
	}

	@Override
	public List<Department> getAllDepartment() {
		return departmentDao.getAllDepartment();
	}

	@Override
	public void addDepartment(Department department) {
		departmentDao.addDepartment(department);
	}

	@Override
	public void updateDepartment(Department department) {
		departmentDao.updateDepartment(department);
	}

	@Override
	public void deleteDepartmentByID(String deptNo) {
		Department department = departmentDao.getDepartmentById(deptNo);
		departmentDao.deleteDepartment(department);
	}

	@Override
	public Set<Employee> getEmployeesByDepartmentID(String deptNo) {
		return departmentDao.getEmployeesByDepartmentID(deptNo);
	}

}
