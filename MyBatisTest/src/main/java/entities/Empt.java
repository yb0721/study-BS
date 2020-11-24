package entities;

import java.sql.Timestamp;
import java.util.List;

public class Empt {

    private int empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Timestamp hiredate;
    private Integer sal;
    private Integer comm;

    //private Dept depts;
    private List<Dept> depts;

    public String toString() {
        return "Empt{" + "empno=" + empno + ",ename=" + ename +  ",job=" + job + ",sal=" + sal + '}'; 
    }

    // public Dept getDepts() {
    //     return depts;
    // }
    // public void setDepts(Dept depts) {
    //     this.depts = depts;
    // }

    public List<Dept> getDepts() {
        return depts;
    }
    public void setDepts(List<Dept> depts) {
        this.depts = depts;
    }

    public int getEmpno() {
        return empno;
    }
    public void setEmpno(int empno) {
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
    public Integer getMgr() {
        return mgr;
    }
    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }
    public Timestamp getHiredate() {
        return hiredate;
    }
    public void setHiredate(Timestamp hiredate) {
        this.hiredate = hiredate;
    }
    public Integer getSal() {
        return sal;
    }
    public void setSal(Integer sal) {
        this.sal = sal;
    }
    public Integer getComm() {
        return comm;
    }
    public void setComm(Integer comm) {
        this.comm = comm;
    }


}