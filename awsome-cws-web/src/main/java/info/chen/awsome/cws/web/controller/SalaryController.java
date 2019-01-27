package info.chen.awsome.cws.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.awsome.cws.common.constants.RequestContextTypeConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.chen.awsome.cws.persist.dto.SalaryDTO;
import info.chen.awsome.cws.persist.entity.Salary;
import info.chen.awsome.cws.persist.exception.SalaryException;
import info.chen.awsome.cws.service.SalaryService;
import info.chen.awsome.cws.web.controller.api.SalaryRestURIContants;
import info.chen.awsome.cws.web.exception.NoSuchSalaryException;

@Controller
public class SalaryController {
	
	@Autowired
	private SalaryService salaryService;

	@RequestMapping(value = SalaryRestURIContants.GET_SALARY, method = RequestMethod.GET)
	public ResponseEntity<List<SalaryDTO>> getSalaries(@PathVariable("empNo") Integer empNo) {
		List<SalaryDTO> salaries = new ArrayList<SalaryDTO>();
		
		try {
			List<Salary> result = salaryService.getSalariesByEmployeeID(empNo);
			for(int i = 0; i < result.size(); i++) {
				salaries.add(SalaryDTO.transferToDTO(result.get(i)));
			}
		} catch (SalaryException e) {
			throw new NoSuchSalaryException();
		}
		return new ResponseEntity<List<SalaryDTO>>(salaries, HttpStatus.OK);
	}
	
	@RequestMapping(value = SalaryRestURIContants.GET_LATEST_SALARY, method = RequestMethod.GET)
	public ResponseEntity<SalaryDTO> getLatestSalary(@PathVariable("empNo") Integer empNo) {
		SalaryDTO salary = null;
		
		try {
			salary = SalaryDTO.transferToDTO(salaryService.getLatestSalary(empNo));
		} catch (SalaryException e) {
			throw new NoSuchSalaryException();
		}
		return new ResponseEntity<SalaryDTO>(salary, HttpStatus.OK);
	}
	
	@RequestMapping(value = SalaryRestURIContants.ADD_SALARY, method = RequestMethod.POST, consumes = {RequestContextTypeConstants.JSON})
	public ResponseEntity<String> addSalary(@RequestBody SalaryDTO salaryDTO) {
		System.out.println(salaryDTO);
		Salary salary = salaryDTO.transferToSalary();
		System.out.println(salary);
		try {
			salaryService.addSalary(salary);
		} catch (SalaryException e) {
			throw new NoSuchSalaryException();
		}
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
}
