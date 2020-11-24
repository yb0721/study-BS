package entities;

import java.util.HashSet;
import java.util.Set;

public class User {

    private int dno;
    private String dname;
    private String loc;

    //一对多关联
    private Set emps = new HashSet();

    public User() {
        
    }

    public User(String dname, String loc) {
        this.dname = dname;
        this.loc = loc;
    }
    
    public Set getEmps() {
        return emps;
    }
    public void setEmps(Set emps) {
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