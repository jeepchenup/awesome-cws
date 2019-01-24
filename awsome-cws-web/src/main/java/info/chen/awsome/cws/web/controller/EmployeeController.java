package info.chen.awsome.cws.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.awsome.cws.common.constants.RequestContextTypeConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import info.chen.awsome.cws.persist.entity.Employee;
import info.chen.awsome.cws.persist.exception.EmployeeException;
import info.chen.awsome.cws.service.EmployeeService;
import info.chen.awsome.cws.web.controller.api.EmployeeRestURIConstants;
import info.chen.awsome.cws.web.exception.NoSuchEmployeeException;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = EmployeeRestURIConstants.GET_EMP, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Employee> getEmployee(@PathVariable("empNo") Integer empNo) {
		Employee employee = new Employee();
		Employee queryEmployee;
		try {
			queryEmployee = employeeService.getEmployeeByEmpID(empNo);
		} catch (EmployeeException e) {
			throw new NoSuchEmployeeException();
		}
		if(queryEmployee == null) {
			return new ResponseEntity<Employee>(employee, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Employee>(queryEmployee, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = EmployeeRestURIConstants.GET_ALL_EMP, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, List<Employee>>> getAllEmployee() {
		
		Map<String, List<Employee>> employeeMap = new HashMap<String, List<Employee>>();
		List<Employee> employees = new ArrayList<Employee>();
		
		try {
			employees = employeeService.getAllEmployees(5000);
			employeeMap.put("employees", employees);
		} catch (EmployeeException e) {
			throw new NoSuchEmployeeException();
		}
		
		return new ResponseEntity<>(employeeMap, HttpStatus.OK);
	}
	
	@RequestMapping(value = EmployeeRestURIConstants.CREATE_EMP, method = RequestMethod.POST, consumes = RequestContextTypeConstants.JSON)
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
		try {
			employeeService.addEmployee(employee);
		} catch(EmployeeException e) {
			throw new DataIntegrityViolationException("Save Employee failed.");
		}
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@RequestMapping(value = EmployeeRestURIConstants.UPDATE_EMP, method = RequestMethod.POST, consumes = RequestContextTypeConstants.JSON)
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		
		try {
			employeeService.updateEmployee(employee);
		} catch (EmployeeException e) {
			throw new DataIntegrityViolationException("Update Employee failed.");
		}
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@RequestMapping(value = EmployeeRestURIConstants.DELETE_EMP, method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteEmployee(@PathVariable("empNo") Integer empNo) {
		try {
			employeeService.deleteEmployee(empNo);
		} catch (EmployeeException e) {
			throw new NoSuchEmployeeException();
		}
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
}
