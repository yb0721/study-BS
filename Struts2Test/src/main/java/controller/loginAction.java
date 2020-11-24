package controller;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class loginAction extends ActionSupport {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private String uname;
    private String upwd;
    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        if("jack".equals(uname) && "123456".equals(upwd)){
            ActionContext actionContext=ActionContext.getContext();
            Map<String,Object> session=actionContext.getSession();
            session.put("uname", this.getUname());
            return "success";
        }else{
            return "error";
        }
        
    }

    public String add() {
        System.out.println("true");
        return "success";
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