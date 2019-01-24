package info.chen.awsome.cws.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.awsome.cws.common.constants.RequestContextTypeConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public Employee getEmployee(@PathVariable("empNo") Integer empNo) {
		Employee employee = new Employee();
		Employee queryEmployee;
		try {
			queryEmployee = employeeService.getEmployeeByEmpID(empNo);
		} catch (EmployeeException e) {
			throw new NoSuchEmployeeException();
		}
		return queryEmployee == null ? employee : queryEmployee;
	}
	
	@RequestMapping(value = EmployeeRestURIConstants.GET_ALL_EMP, method = RequestMethod.GET)
	@ResponseBody
	public Map<String, List<Employee>> getAllEmployee() {
		
		Map<String, List<Employee>> employeeMap = new HashMap<String, List<Employee>>();
		List<Employee> employees = new ArrayList<Employee>();
		
		try {
			employees = employeeService.getAllEmployees(0);
			employeeMap.put("employees", employees);
		} catch (EmployeeException e) {
			throw new NoSuchEmployeeException();
		}
		
		return employeeMap;
	}
	
	@RequestMapping(value = EmployeeRestURIConstants.CREATE_EMP, method = RequestMethod.POST, consumes = RequestContextTypeConstants.JSON)
	public String createEmployee(@RequestBody Employee employee) {
		try {
			employeeService.addEmployee(employee);
		} catch(EmployeeException e) {
			throw new DataIntegrityViolationException("Save Employee failed.");
		}
		return null;
	}
}
