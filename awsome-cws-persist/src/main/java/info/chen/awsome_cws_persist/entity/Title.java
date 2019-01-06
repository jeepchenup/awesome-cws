package info.chen.awsome_cws_persist.entity;

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

import info.chen.awsome_cws_persist.entity.composite_id.TitleID;


@Entity
@Table(name="title")
@DynamicInsert
@DynamicUpdate
public class Title implements Serializable{

	private static final long serialVersionUID = 1535405469691564931L;

	@EmbeddedId
	@AttributeOverrides(value = { @AttributeOverride(column = @Column(name="emp_no"), name = "empNo"),
			                      @AttributeOverride(column = @Column(name="from_date"), name="fromDate")})
	private TitleID titleID;
	
	@Column(name="to_date")
	@Type(type="date")
	private Date toDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("emp_no")
	@JoinColumn(referencedColumnName="emp_no", name="emp_no")
	private Employee employee;

	public TitleID getTitleID() {
		return titleID;
	}

	public void setTitleID(TitleID titleID) {
		this.titleID = titleID;
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
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((titleID == null) ? 0 : titleID.hashCode());
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
		Title other = (Title) obj;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (titleID == null) {
			if (other.titleID != null)
				return false;
		} else if (!titleID.equals(other.titleID))
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
		return "Title [titleID=" + titleID + ", toDate=" + toDate + "]";
	}
	
}
