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

import info.chen.awsome.cws.persist.entity.composite_id.DepartmentManagerID;

@Entity
@Table(name = "department_manager")
public class DepartmentManager implements Serializable {

	private static final long serialVersionUID = -6027220294827742844L;

	@EmbeddedId
	@AttributeOverrides(value = { @AttributeOverride(column = @Column(name = "emp_no"), name = "empNo"),
													@AttributeOverride(column = @Column(name = "dept_no", columnDefinition = "char(4)"), name = "deptNo")})
	private DepartmentManagerID dmID;

	@Column(name = "from_date", columnDefinition = "date")
	private Date fromDate;
	@Column(name = "to_date", columnDefinition = "date")
	private Date toDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("emp_no")
	@JoinColumn(referencedColumnName = "emp_no", name = "emp_no")
	private Employee manager;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("dept_no")
	@JoinColumn(referencedColumnName = "dept_no", name = "dept_no")
	private Department department;
	
	public DepartmentManagerID getDmID() {
		return dmID;
	}
	public void setDmID(DepartmentManagerID dmID) {
		this.dmID = dmID;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((dmID == null) ? 0 : dmID.hashCode());
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
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
		DepartmentManager other = (DepartmentManager) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (dmID == null) {
			if (other.dmID != null)
				return false;
		} else if (!dmID.equals(other.dmID))
			return false;
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
			return false;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
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
		return "DepartmentManager [dmID=" + dmID + ", fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}
}
