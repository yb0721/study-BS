package entities;

import java.util.HashSet;
import java.util.Set;

public class Role {

    private int rid;
    private String rname;
    private Set privileges = new HashSet();

    public Role() {}
    public Role(String rname) {
        this.rname = rname;
    }

    public Set getPrivileges() {
        return privileges;
    }
    public void setPrivileges(Set privileges) {
        this.privileges = privileges;
    }

    public int getRid() {
        return rid;
    }
    public void setRid(int rid) {
        this.rid = rid;
    }
    public String getRname() {
        return rname;
    }
    public void setRname(String rname) {
        this.rname = rname;
    }
}