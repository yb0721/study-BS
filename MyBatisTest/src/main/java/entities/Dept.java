package entities;

import java.util.HashSet;
import java.util.List;

public class Dept {

    private int dno;
    private String dname;
    private String loc;

    //一对多关联
    private List<Empt> emps;

    public String toString() {
        return "Dept{" + "dno=" + dno + "dname=" + dname + "loc=" + loc + '}';
    }
    
    public List<Empt> getEmps() {
        return emps;
    }
    public void setEmps(List<Empt> emps) {
        this.emps = emps;
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