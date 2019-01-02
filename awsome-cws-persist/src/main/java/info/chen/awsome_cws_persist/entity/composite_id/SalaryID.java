package info.chen.awsome_cws_persist.entity.composite_id;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;

@Embeddable
public class SalaryID implements Serializable{

	Integer empNo;
	
	@Type(type = "date")
	Date fromDate;
	
	public SalaryID() {
	}
	
	public SalaryID(Integer empNo, Date fromDate) {
		this.empNo = empNo;
		this.fromDate = fromDate;
	}
	
	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	@Override
	public boolean equals(Object obj) {
		SalaryID salaryID = (SalaryID) obj;
		if(this.empNo == salaryID.empNo && this.fromDate == salaryID.fromDate) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "SalaryID [empNo=" + empNo + ", fromDate=" + fromDate + "]";
	}
	
}
