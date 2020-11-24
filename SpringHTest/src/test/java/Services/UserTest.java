package Services;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserDao;
import entities.User;

public class UserTest {

    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" });
        UserDao userdao = (UserDao) context.getBean("dao");
        List<User> user = userdao.find("from User c");
        System.out.println(user);
    }
}