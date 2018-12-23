package info.chen.awsome_cws.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import info.chen.awsome_cws.dao.AbstractDao;
import info.chen.awsome_cws.dao.DepartmentDao;
import info.chen.awsome_cws.entity.Department;

@Repository
@Transactional
public class DepartmentDaoImpl extends AbstractDao<Department> implements DepartmentDao {

	@Override
	public List<Department> getAllDepartment() {
		Criteria ctiteria = getCriteria();
		ctiteria.addOrder(Order.asc("id"));
		return ctiteria.list();
	}

	@Override
	public void addDepartment(Department department) {
		persistEntity(department);
	}

	@Override
	public void updateDepartment(Department department) {
		updateEntity(department);
	}

	@Override
	public void deleteDepartment(Department department) {
		deleteEntity(department);
	}

	@Override
	public Department getDepartmentById(String id) {
		return (Department) getSession().get(Department.class, id);
	}

}
