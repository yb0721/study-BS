package Services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import entities.User;
import mappers.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserTest {

    @Autowired
    private UserMapper usermapper;

    @Test
    public void test() {
        User u = new User();
        u.setUname("yang");
        u.setUpwd("123456");
        User user = usermapper.getUser(u);
        System.out.println(user);
    }
}