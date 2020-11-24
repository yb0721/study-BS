package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserModel;

public class LoginAction implements Action {
    public String execute(HttpServletRequest request, HttpServletResponse reponse) {
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");

        //调用UserModel逻辑层的方法
        UserModel um = new UserModel();
        if(um.isExistUser(uname, upwd)) {
            request.getSession().setAttribute("uname", uname);// 对uname进行赋值
            return "index.jsp";
        }
        else {
            return "index.jsp";
        }
    }
}