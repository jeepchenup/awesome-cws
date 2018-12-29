package info.chen.awsome_cws.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department implements Serializable {

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
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
}
