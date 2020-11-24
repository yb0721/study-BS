package controller;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.ServletRequestAware;

import model.LoginModel;

import javax.servlet.http.HttpServletRequest;

public class LoginAction extends ActionSupport implements ServletRequestAware{
    HttpServletRequest request;
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public String login() throws Exception{
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");

        LoginModel lm = new LoginModel();
        if(lm.Login(uname, upwd) == true) {
            return "success";
        }
        else {
            request.getSession().setAttribute("uname", uname);
            return "error";
        }
        
    }

    public String reg() throws Exception {
        String username = request.getParameter("uname");
        String userpwd = request.getParameter("upwd");

        LoginModel user = new LoginModel();

        if(user.Reg(username, userpwd) == true) {
            request.getSession().setAttribute("username", username);
            return "success";
        }
        else {
            return "error";
        }
    }

    public void setServletRequest(HttpServletRequest request) {
        this.request = request;

    }
}