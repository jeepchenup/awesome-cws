package info.chen.awsome.cws.persist.entity.composite_id;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;

@Embeddable
public class SalaryID implements Serializable{

	private static final long serialVersionUID = -4387314594394381245L;

	private Integer empNo;
	
	@Type(type = "date")
	private Date fromDate;
	
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empNo == null) ? 0 : empNo.hashCode());
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
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
		SalaryID other = (SalaryID) obj;
		if (empNo == null) {
			if (other.empNo != null)
				return false;
		} else if (!empNo.equals(other.empNo))
			return false;
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "SalaryID [empNo=" + empNo + ", fromDate=" + fromDate + "]";
	}
}
