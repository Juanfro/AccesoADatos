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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author alumno
 */
@Entity
@Table(name = "aula")
@NamedQueries({
    @NamedQuery(name = "Aula.findAll", query = "SELECT a FROM Aula a")})
public class Aula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODA")
    private String coda;
    @Column(name = "NomGrupos")
    private String nomGrupos;
    @Column(name = "Estado")
    private String estado;
    @Column(name = "Revisor")
    private String revisor;

    public Aula() {
    }

    public Aula(String coda) {
        this.coda = coda;
    }

    public String getCoda() {
        return coda;
    }

    public void setCoda(String coda) {
        this.coda = coda;
    }

    public String getNomGrupos() {
        return nomGrupos;
    }

    public void setNomGrupos(String nomGrupos) {
        this.nomGrupos = nomGrupos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coda != null ? coda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aula)) {
            return false;
        }
        Aula other = (Aula) object;
        if ((this.coda == null && other.coda != null) || (this.coda != null && !this.coda.equals(other.coda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Aula[ coda=" + coda + " ]";
    }
    
}
