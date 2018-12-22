package info.chen.awsome_cws.dao.impl;

import java.util.List;

import info.chen.awsome_cws.dao.AbstractDao;
import info.chen.awsome_cws.dao.DepartmentDao;
import info.chen.awsome_cws.entity.Department;

public class DepartmentDaoImpl extends AbstractDao<Department> implements DepartmentDao {

	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDepartment(Department department) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDepartment(Department department) {
		// TODO Auto-generated method stub

	}

	@Override
	public Department getDepartmentById(int id) {
		return (Department) getSession().get(Department.class, id);
	}

}
