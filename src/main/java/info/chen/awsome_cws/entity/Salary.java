package info.chen.awsome_cws.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.Type;

import info.chen.awsome_cws.entity.composite_id.SalaryID;

@Entity
@Table(name="salary", schema="awsome_cws")
public class Salary implements Serializable{
	
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name="empNo", column = @Column(name = "emp_no")),
						  @AttributeOverride(name="fromDate", column = @Column(name = "from_date"))})
	private SalaryID salaryID;

	@Column
	private Integer salary;
	
	@Column(name="to_date")
	@Type(type = "date")
	private Date toDate;
	
	// 一条工资信息只能找到一条员工的信息
	@MapsId("emp_no")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "emp_no", referencedColumnName="emp_no", nullable = false)
	private Employee employee;

	public SalaryID getSalaryID() {
		return salaryID;
	}

	public void setSalaryID(SalaryID salaryID) {
		this.salaryID = salaryID;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Salary [salaryID=" + salaryID + ", salary=" + salary + ", toDate=" + toDate + "]";
	}
	
}
