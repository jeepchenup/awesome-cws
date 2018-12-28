package info.chen.awsome_cws.entity;

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

import info.chen.awsome_cws.entity.composite_id.DepartmentEmployeeID;

@Entity
@Table(name = "department_employee")
public class DepartmentEmployee implements Serializable{

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

	@Override
	public String toString() {
		return "DepartmentManager [deID=" + deID + ", fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}
}
