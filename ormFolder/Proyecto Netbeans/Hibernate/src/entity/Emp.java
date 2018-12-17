package entity;
// Generated 17-dic-2018 12:29:19 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Emp generated by hbm2java
 */
@Entity
@Table(name = "emp",
         catalog = "scott"
)
public class Emp implements java.io.Serializable {

    private short empno;
    private Dept dept;
    private Emp emp;
    private String ename;
    private String job;
    private Date hiredate;
    private BigDecimal sal;
    private BigDecimal comm;
    private Set<Emp> emps = new HashSet(0);

    public Emp() {
    }

    public Emp(short empno) {
        this.empno = empno;
    }

    public Emp(short empno, Dept dept, Emp emp, String ename, String job, Date hiredate, BigDecimal sal, BigDecimal comm, Set emps) {
        this.empno = empno;
        this.dept = dept;
        this.emp = emp;
        this.ename = ename;
        this.job = job;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.emps = emps;
    }

    @Id

    @Column(name = "empno", unique = true, nullable = false, precision = 4, scale = 0)
    public short getEmpno() {
        return this.empno;
    }

    public void setEmpno(short empno) {
        this.empno = empno;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptno")
    public Dept getDept() {
        return this.dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mgr")
    public Emp getEmp() {
        return this.emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    @Column(name = "ename", length = 10)
    public String getEname() {
        return this.ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Column(name = "job", length = 9)
    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "hiredate", length = 10)
    public Date getHiredate() {
        return this.hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    @Column(name = "sal", precision = 7)
    public BigDecimal getSal() {
        return this.sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    @Column(name = "comm", precision = 7)
    public BigDecimal getComm() {
        return this.comm;
    }

    public void setComm(BigDecimal comm) {
        this.comm = comm;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "emp")
    public Set<Emp> getEmps() {
        return this.emps;
    }

    public void setEmps(Set<Emp> emps) {
        this.emps = emps;
    }

}
