package info.chen.awsome_cws.entity.composite_id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DepartmentEmployeeID implements Serializable {

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
	public String toString() {
		return "DepartmentEmployeeID [empNo=" + empNo + ", deptNo=" + deptNo + "]";
	}
}
