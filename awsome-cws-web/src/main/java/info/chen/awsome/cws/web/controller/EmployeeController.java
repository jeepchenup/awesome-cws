package info.chen.awsome.cws.web.controller;

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
			employee.setDepartmentEmployees(null);
		} catch (EmployeeException e) {
		}
		return employee;
	}
}
