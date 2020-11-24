package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.UserService;
import org.springframework.web.bind.annotation.RequestMethod;

import entities.User;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String username, String password) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        List<User> u = null;
        
        try {
            
            u = userService.login(user);
            if(u != null) {
                System.out.println("登录成功");

                //封装数据并传值
                session.setAttribute("u", u);
                return "redirect:/book/listBook";
            }
            else {
                System.out.println("7");
                System.out.println("登录失败");
                return "redirect:/index.jsp";
            }

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            System.out.println("登录失败");
            return "redirect:/index.jsp";
        }
    }

    @RequestMapping(value = "reg", method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    public String reg(String username, String password) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        try {
            userService.reg(user);
            return "redirect:/index.jsp";
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            return "error";
        }
    }

}