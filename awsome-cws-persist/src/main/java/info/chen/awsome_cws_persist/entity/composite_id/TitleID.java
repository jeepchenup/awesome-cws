package info.chen.awsome_cws_persist.entity.composite_id;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;

@Embeddable
public class TitleID implements Serializable{

	private Integer empNo;
	private String title;
	@Type(type="date")
	private Date fromDate;
	
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	@Override
	public String toString() {
		return "TitleID [empNo=" + empNo + ", title=" + title + ", fromDate=" + fromDate + "]";
	}
}
