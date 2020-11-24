package entities;

public class Dept {

    private int dno;
    private String dname;
    private String loc;

    public String toString() {
        return "Dept{" + "dno=" + dno + "dname=" + dname + "loc=" + loc + '}';
    }
    public int getDno() {
        return dno;
    }
    public void setDno(int dno) {
        this.dno = dno;
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
}