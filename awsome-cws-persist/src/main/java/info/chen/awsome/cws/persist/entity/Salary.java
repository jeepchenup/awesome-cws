package info.chen.awsome.cws.persist.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

import info.chen.awsome.cws.persist.entity.composite_id.SalaryID;

@Entity
@Table(name="salary")
@DynamicInsert
@DynamicUpdate
public class Salary implements Serializable{
	
	private static final long serialVersionUID = 7443594059888295812L;

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name="empNo", column = @Column(name = "emp_no")),
						  @AttributeOverride(name="fromDate", column = @Column(name = "from_date"))})
	private SalaryID salaryID;

	@Column
	private Integer salary;
	
	@Column(name="to_date")
	@Type(type = "date")
	private Date toDate;
	
	@JsonIgnore
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		result = prime * result + ((salaryID == null) ? 0 : salaryID.hashCode());
		result = prime * result + ((toDate == null) ? 0 : toDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salary other = (Salary) obj;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		if (salaryID == null) {
			if (other.salaryID != null)
				return false;
		} else if (!salaryID.equals(other.salaryID))
			return false;
		if (toDate == null) {
			if (other.toDate != null)
				return false;
		} else if (!toDate.equals(other.toDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Salary [salaryID=" + salaryID + ", salary=" + salary + ", toDate=" + toDate + "]";
	}
	
}
