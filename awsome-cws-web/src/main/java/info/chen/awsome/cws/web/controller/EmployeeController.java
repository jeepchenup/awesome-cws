package info.chen.awsome.cws.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import info.chen.awsome.cws.persist.entity.Employee;
import info.chen.awsome.cws.persist.exception.EmployeeException;
import info.chen.awsome.cws.service.EmployeeService;
import info.chen.awsome.cws.web.controller.api.EmployeeRestURIConstants;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = EmployeeRestURIConstants.GET_EMP, method = RequestMethod.GET)
	@ResponseBody
	public Employee getEmployee(@PathVariable("empNo") Integer empNo) {
		Employee employee = new Employee();
		try {
			employee = employeeService.getEmployeeByEmpID(empNo);
		} catch (EmployeeException e) {
		}
		return employee;
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
			e.printStackTrace();
		}
		
		return employeeMap;
	}
}
