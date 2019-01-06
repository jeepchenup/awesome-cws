package info.chen.awsome_cws_persist.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="department")
@DynamicInsert
@DynamicUpdate
public class Department implements Serializable {

	private static final long serialVersionUID = 1419774341022858745L;

	@Id
	@Column(name="dept_no", columnDefinition="char(4)")
	private String id;
	
	@Column(name="dept_name")
	private String name;
	
	@OneToMany(mappedBy = "department")
	private Set<DepartmentEmployee> deptEmpSet = new HashSet<DepartmentEmployee>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<DepartmentEmployee> getDeptEmpSet() {
		return deptEmpSet;
	}

	public void setDeptEmpSet(Set<DepartmentEmployee> deptEmpSet) {
		this.deptEmpSet = deptEmpSet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Department other = (Department) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
}
