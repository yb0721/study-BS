package entities;

public class User {

    private int uid;
    private String uname;
    private String upwd;

    public String toString() {
        return "User{" + "uid=" + uid + ",uname=" + uname + ",upwd=" + upwd + "}";
    }

    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getUpwd() {
        return upwd;
    }
    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }
    
}