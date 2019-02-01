package info.chen.awsome.cws.persist.dto;

import java.util.Date;

import org.awsome.cws.common.constants.DateConstants;

import com.fasterxml.jackson.annotation.JsonFormat;

import info.chen.awsome.cws.persist.entity.Salary;
import info.chen.awsome.cws.persist.entity.composite_id.SalaryID;

public class SalaryDTO {

	private Integer empNo;
	
	private Integer salary;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateConstants.YYYY_MM_DD_PATTERN)
	private Date fromDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateConstants.YYYY_MM_DD_PATTERN)
	private Date toDate;

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	public static SalaryDTO transferToDTO(Salary salary) {
		SalaryDTO dto = new SalaryDTO();
		
		dto.setEmpNo(salary.getSalaryID().getEmpNo());
		dto.setSalary(salary.getSalary());
		dto.setFromDate(salary.getSalaryID().getFromDate());
		dto.setToDate(salary.getToDate());
		
		return dto;
	}
	
	public Salary transferToSalary() {
		Salary salary = new Salary();
		SalaryID salaryID = new SalaryID();
		
		salaryID.setEmpNo(this.getEmpNo());
		salaryID.setFromDate(this.getFromDate());
		salary.setSalaryID(salaryID);
		salary.setSalary(this.getSalary());
		salary.setToDate(this.getToDate());
		
		return salary;
	}

	@Override
	public String toString() {
		return "SalaryDTO [empNo=" + empNo + ", salary=" + salary + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ "]";
	}
}
