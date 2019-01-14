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

import info.chen.awsome.cws.persist.entity.composite_id.DepartmentEmployeeID;

@Entity
@Table(name = "department_employee")
public class DepartmentEmployee implements Serializable{

	private static final long serialVersionUID = 8325904407437045461L;

	@EmbeddedId
	@AttributeOverrides(value = { @AttributeOverride(column = @Column(name = "dept_no", columnDefinition = "char(4)"), name = "deptNo"),
												   @AttributeOverride(column = @Column(name = "emp_no"), name = "empNo")})
	private DepartmentEmployeeID deID;
	
	@Column(name = "from_date", columnDefinition = "date")
	private Date fromDate;
	
	@Column(name = "to_date", columnDefinition = "date")
	private Date toDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("emp_no")
	@JoinColumn(referencedColumnName = "emp_no", name = "emp_no")
	private Employee employee;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("dept_no")
	@JoinColumn(referencedColumnName = "dept_no", name = "dept_no")
	private Department department;

	public DepartmentEmployeeID getDeID() {
		return deID;
	}

	public void setDeID(DepartmentEmployeeID deID) {
		this.deID = deID;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deID == null) ? 0 : deID.hashCode());
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
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
		DepartmentEmployee other = (DepartmentEmployee) obj;
		if (deID == null) {
			if (other.deID != null)
				return false;
		} else if (!deID.equals(other.deID))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
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
		return "DepartmentManager [deID=" + deID + ", fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}
}
