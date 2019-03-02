/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipulacionObjetos.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Juan
 */
@Entity
@Table(name = "dept")
@NamedQueries({ @NamedQuery(name = "Dept.findAll", query = "SELECT d FROM Dept d") })
public class Dept implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "deptno")
	private Short deptno;
	@Column(name = "dname")
	private String dname;
	@Column(name = "loc")
	private String loc;
	@OneToMany(mappedBy = "deptno")
	private Collection<Emp> empCollection;

	public Dept() {
	}

	public Dept(Short deptno) {
		this.deptno = deptno;
	}

	public Short getDeptno() {
		return deptno;
	}

	public void setDeptno(Short deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public Collection<Emp> getEmpCollection() {
		return empCollection;
	}

	public void setEmpCollection(Collection<Emp> empCollection) {
		this.empCollection = empCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (deptno != null ? deptno.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Dept)) {
			return false;
		}
		Dept other = (Dept) object;
		if ((this.deptno == null && other.deptno != null)
				|| (this.deptno != null && !this.deptno.equals(other.deptno))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entity.Dept[ deptno=" + deptno + " ]";
	}

}
