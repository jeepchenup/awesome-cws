package info.chen.awsome_cws.service;

import java.util.List;

import info.chen.awsome_cws.entity.Salary;

public interface SalaryService {

	List<Salary> getSalariesByEmployeeID(Integer id);
}
