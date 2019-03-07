/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenHibernate;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author alumno
 */
@Entity
@Table(name = "profe")
@NamedQueries({ @NamedQuery(name = "Profe.findAll", query = "SELECT p FROM Profe p") })
public class Profe implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "CODP")
	private String codp;

	@Basic(optional = false)
	@Column(name = "NombreP")
	private String nombreP;

	@Column(name = "Edad")
	private Integer edad;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "codprof")
	private Set<Alumno> alumnoSet;

	public Profe() {
	}

	public Profe(String codp) {
		this.codp = codp;
	}

	public Profe(String codp, String nombreP) {
		this.codp = codp;
		this.nombreP = nombreP;
	}

	public String getCodp() {
		return codp;
	}

	public void setCodp(String codp) {
		this.codp = codp;
	}

	public String getNombreP() {
		return nombreP;
	}

	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Set<Alumno> getAlumnoSet() {
		return alumnoSet;
	}

	public void setAlumnoSet(Set<Alumno> alumnoSet) {
		this.alumnoSet = alumnoSet;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (codp != null ? codp.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Profe)) {
			return false;
		}
		Profe other = (Profe) object;
		if ((this.codp == null && other.codp != null) || (this.codp != null && !this.codp.equals(other.codp))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entity.Profe[ codp=" + codp + " ]";
	}

}
