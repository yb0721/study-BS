package entities;

import java.util.HashSet;
import java.util.Set;

public class Privilege {

    private int pid;
    private String pname;
    private Set roles = new HashSet();

    public Privilege() {}
    public Privilege(String pname) {
        this.pname = pname;
    }

    public Set getRoles() {
        return roles;
    }
    public void setRoles(Set roles) {
        this.roles = roles;
    }

    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
}