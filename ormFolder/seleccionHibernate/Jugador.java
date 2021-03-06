/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleccionHibernate;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Juan
 */
@Entity
@Table(name = "jugador")
@NamedQueries({ @NamedQuery(name = "Jugador.findAll", query = "SELECT j FROM Jugador j") })
public class Jugador implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;

	@Basic(optional = false)
	@Column(name = "dorsal")
	private int dorsal;

	@Basic(optional = false)
	@Column(name = "nombre")
	private String nombre;

	@Basic(optional = false)
	@Column(name = "posicion")
	private String posicion;

	public Jugador() {
	}

	public Jugador(Integer id) {
		this.id = id;
	}

	public Jugador(Integer id, int dorsal, String nombre, String posicion) {
		this.id = id;
		this.dorsal = dorsal;
		this.nombre = nombre;
		this.posicion = posicion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Jugador)) {
			return false;
		}
		Jugador other = (Jugador) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entity.Jugador[ id=" + id + " ]";
	}

}
