package controller;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String uname;
    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        if("jack".equals(uname)){
            ActionContext actionContext=ActionContext.getContext();
            Map<String,Object> session=actionContext.getSession();
            session.put("uname", this.getUname());
            return "success";
        }else{
            return "error";
        }
        
    }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }
}