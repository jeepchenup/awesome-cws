package info.chen.awsome_cws_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import info.chen.awsome_cws_persist.entity.Employee;
import info.chen.awsome_cws_service.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/employee/get")
	public Employee getEmployee(@RequestParam(name = "empNo") Integer empNo) {
		Employee employee = null;
		employee = employeeService.getEmployeeByEmpID(empNo);
		return employee;
	}
}
