package info.chen.awsome_cws_service.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.chen.awsome_cws_persist.dao.DepartmentDao;
import info.chen.awsome_cws_persist.entity.Department;
import info.chen.awsome_cws_persist.entity.Employee;
import info.chen.awsome_cws_service.service.DepartmentService;

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
	public void deleteDepartment(Department department) {
		departmentDao.deleteDepartment(department);
	}

	@Override
	public Set<Employee> getEmployeesByDepartmentID(String deptNo) {
		return departmentDao.getEmployeesByDepartmentID(deptNo);
	}

}
