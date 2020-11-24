package entities;

public class Empt {
    private int empno;
    private String ename;
    private String job;

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

    public String toString() {
        return "Empt[empno=" + empno + ",ename=" + ename + ",job=" + job + "]";
    }
}