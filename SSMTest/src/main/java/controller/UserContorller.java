package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.ResponseBody;

import entities.User;
import service.UserService;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserContorller {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    // @ResponseBody
    public String login(HttpSession session, String uname, String upwd) {
        System.out.println("controller");

        //获取用户请求，再实现业务逻辑
        User u = new User();
        u.setUname(uname);
        u.setUpwd(upwd);
        User user = null;

        try {
            user = userService.login(u);
            if(user != null) {
                System.out.println(user.getUid()+":" + user.getUname() + "登录成功！");
                session.setAttribute("user", user);
                // return "main";
                return "forward:/dept/listDept";
            }
            else {
                System.out.println(user.getUid()+":" + user.getUname() + "登录失败！");
                return "redirect:/error.jsp";
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("登陆失败！");
            return "redirect:/error.jsp";
        }
    }
}