package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.UserModel;

public class HelloController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");

        UserModel um = new UserModel();
        if(um.isExistUser(uname, upwd)) {
            request.getSession().setAttribute("message", uname);
            return new ModelAndView("hello");
        }
        else {
            return new ModelAndView("index");
        }
    }
} 