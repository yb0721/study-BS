package service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.User;

public class UserTest {

    @Test
    public void testlogin() {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserBiz userBiz = (UserBiz)context.getBean("userBiz");
        User user = userBiz.login("张三","123456");
        if(user != null) {
            System.out.println("登录成功");
        }
        else {
            System.out.println("登陆失败");
        }
    }
}