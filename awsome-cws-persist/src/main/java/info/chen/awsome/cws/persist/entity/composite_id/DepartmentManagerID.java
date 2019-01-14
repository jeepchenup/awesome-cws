package info.chen.awsome.cws.persist.entity.composite_id;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DepartmentManagerID implements Serializable {

	private static final long serialVersionUID = -2019564563314333268L;
	private Integer empNo;
	private String deptNo;
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deptNo == null) ? 0 : deptNo.hashCode());
		result = prime * result + ((empNo == null) ? 0 : empNo.hashCode());
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
		DepartmentManagerID other = (DepartmentManagerID) obj;
		if (deptNo == null) {
			if (other.deptNo != null)
				return false;
		} else if (!deptNo.equals(other.deptNo))
			return false;
		if (empNo == null) {
			if (other.empNo != null)
				return false;
		} else if (!empNo.equals(other.empNo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DepartmentManagerID [empNo=" + empNo + ", deptNo=" + deptNo + "]";
	}
}
