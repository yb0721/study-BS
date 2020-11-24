package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.JdbcDao;

// @WebServlet(urlpatterns = "/login")
public class LoginServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        
        String uname=request.getParameter("username");
        String pwd=request.getParameter("password");
        System.out.println(uname+":"+pwd);

        // if(uname.equals("sehun") && pwd.equals("1111")) {
        //     System.out.println("验证成功");
        // }
        // else {
        //     System.out.println("验证失败");
        // }

        if(new JdbcDao().isExistUser(uname, pwd)) {
            System.out.println("验证成功");
            request.getSession().setAttribute("username",uname);
            request.getRequestDispatcher("WEB-INF/success.jsp").forward(request, response);
        }
        else {
            System.out.println("验证失败");
        }
    }
}