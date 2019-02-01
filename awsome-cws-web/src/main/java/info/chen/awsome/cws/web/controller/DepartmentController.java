package info.chen.awsome.cws.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.awsome.cws.common.constants.RequestContextTypeConstants;
import org.awsome.cws.common.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.TransientDataAccessResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.chen.awsome.cws.persist.entity.Department;
import info.chen.awsome.cws.persist.exception.DepartmentException;
import info.chen.awsome.cws.service.DepartmentService;
import info.chen.awsome.cws.web.controller.api.DepartmentRestURIConstants;
import info.chen.awsome.cws.web.exception.NoSuchDepartmentException;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptService;

	@RequestMapping(value = DepartmentRestURIConstants.GET_DEPT, method = RequestMethod.GET)
	public ResponseEntity<Department> getDepartment(@PathVariable("deptNo") String deptNo) {
		if(CommonUtils.isEmpty(deptNo)) {
			throw new NullPointerException("Department Number Must Not Be Null.");
		}
		Department department = null;
		try {
			department = deptService.getDepartmentById(deptNo);
		} catch (DepartmentException e) {
			throw new NoSuchDepartmentException("Can Not Find Such Department.");
		}
		
		return new ResponseEntity<Department>(department, HttpStatus.OK);
	}
	
	@RequestMapping(value = DepartmentRestURIConstants.GET_ALL_DEPT, method = RequestMethod.GET)
	public ResponseEntity<Map<String, List<Department>>> getAllDepartment() {
		List<Department> departments;
		try {
			departments = deptService.getAllDepartment();
		} catch (DepartmentException e) {
			throw new TransientDataAccessResourceException("DataAccessException");
		}
		Map<String, List<Department>> departmentMap = new HashMap<String, List<Department>>();
		departmentMap.put("departments", departments);
		return new ResponseEntity<>(departmentMap, HttpStatus.OK);
	}
	
	@RequestMapping(value = DepartmentRestURIConstants.CREATE_DEPT, method = RequestMethod.POST, consumes = RequestContextTypeConstants.JSON)
	public ResponseEntity<String> addDepartment(@RequestBody Department department) {
		if(null == department) {
			throw new NullPointerException("Need a Department Entity.");
		}
		try {
			deptService.addDepartment(department);
		} catch (DepartmentException e) {
			throw new DataIntegrityViolationException("Department Save Failed.");
		}
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@RequestMapping(value = DepartmentRestURIConstants.UPDATE_DEPT, method = RequestMethod.POST, consumes = RequestContextTypeConstants.JSON)
	public ResponseEntity<String> updateDepartment(@RequestBody Department department) {
		if(null == department) {
			throw new NullPointerException("Need a Department Entity.");
		}
		try {
			deptService.updateDepartment(department);
		} catch (DepartmentException e) {
			throw new DataIntegrityViolationException("Department Update Failed.");
		}
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@RequestMapping(value = DepartmentRestURIConstants.DELETE_DEPT, method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteDepartment(@PathVariable("deptNo") String deptNo) {
		if(CommonUtils.isEmpty(deptNo)) {
			throw new NullPointerException("Department Number Must Not Be Null.");
		}
		try {
			deptService.deleteDepartmentByID(deptNo);
		} catch (DepartmentException e) {
			throw new NoSuchDepartmentException("Can Not Find Such Department.");
		}
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
}
