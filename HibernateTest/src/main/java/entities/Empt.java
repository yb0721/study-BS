package entities;

import java.sql.Timestamp;


public class Empt {
    
    private int empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Timestamp hiredate;
    private Integer sal;
    private Integer comm;

    //双向一对多以及单向多对一
    private User dept;

    public Empt(){}

    public Empt(int empno,String ename) {
        this.empno = empno;
        this.ename = ename;
    }

    public String toString() {
        return "Empt{" + "empno=" + empno + ",ename='" + ename + '\'' + ",job='" + job + '\''
                     + ",mgr=" + mgr + ",hiredate=" + hiredate + ",sal=" + sal + ",comm=" + comm
                     + '}'; 
    }

    public User getDept() {
        return dept;
    }
    public void setDept(User dept) {
        this.dept = dept;
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