/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenHibernate;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author alumno
 */
@Entity
@Table(name = "alumno")
@NamedQueries({ @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a") })
public class Alumno implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "DNI")
	private String dni;

	@Column(name = "NombreA")
	private String nombreA;

	@Column(name = "DireccionA")
	private String direccionA;

	@JoinColumn(name = "Cod_prof", referencedColumnName = "CODP")
	@ManyToOne(optional = false)
	private Profe codprof;

	public Alumno() {
	}

	public Alumno(String dni) {
		this.dni = dni;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombreA() {
		return nombreA;
	}

	public void setNombreA(String nombreA) {
		this.nombreA = nombreA;
	}

	public String getDireccionA() {
		return direccionA;
	}

	public void setDireccionA(String direccionA) {
		this.direccionA = direccionA;
	}

	public Profe getCodprof() {
		return codprof;
	}

	public void setCodprof(Profe codprof) {
		this.codprof = codprof;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (dni != null ? dni.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Alumno)) {
			return false;
		}
		Alumno other = (Alumno) object;
		if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entity.Alumno[ dni=" + dni + " ]";
	}

}
