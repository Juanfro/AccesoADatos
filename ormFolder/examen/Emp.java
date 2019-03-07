/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Juan
 */
@Entity
@Table(name = "emp")
@NamedQueries({
    @NamedQuery(name = "Emp.findAll", query = "SELECT e FROM Emp e")})
public class Emp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "empno")
    private Short empno;
    @Column(name = "ename")
    private String ename;
    @Column(name = "job")
    private String job;
    @Column(name = "hiredate")
    @Temporal(TemporalType.DATE)
    private Date hiredate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sal")
    private BigDecimal sal;
    @Column(name = "comm")
    private BigDecimal comm;
    @JoinColumn(name = "deptno", referencedColumnName = "deptno")
    @ManyToOne
    private Dept deptno;
    @OneToMany(mappedBy = "mgr")
    private Set<Emp> empSet;
    @JoinColumn(name = "mgr", referencedColumnName = "empno")
    @ManyToOne
    private Emp mgr;

    public Emp() {
    }

    public Emp(Short empno) {
        this.empno = empno;
    }

    public Short getEmpno() {
        return empno;
    }

    public void setEmpno(Short empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    public BigDecimal getComm() {
        return comm;
    }

    public void setComm(BigDecimal comm) {
        this.comm = comm;
    }

    public Dept getDeptno() {
        return deptno;
    }

    public void setDeptno(Dept deptno) {
        this.deptno = deptno;
    }

    public Set<Emp> getEmpSet() {
        return empSet;
    }

    public void setEmpSet(Set<Emp> empSet) {
        this.empSet = empSet;
    }

    public Emp getMgr() {
        return mgr;
    }

    public void setMgr(Emp mgr) {
        this.mgr = mgr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empno != null ? empno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emp)) {
            return false;
        }
        Emp other = (Emp) object;
        if ((this.empno == null && other.empno != null) || (this.empno != null && !this.empno.equals(other.empno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Emp[ empno=" + empno + " ]";
    }
    
}
