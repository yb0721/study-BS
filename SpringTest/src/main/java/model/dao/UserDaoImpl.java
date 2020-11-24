package model.dao;

import org.springframework.stereotype.Repository;

import model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public User findUser(String username, String password) {
        // TODO Auto-generated method stub
        if("张三".equals(username)&&"123456".equals(password)) {
            System.out.println(username + "正在登录中...");
            return new User(username, password);
        }
        else {
            return null;
        }
    }
}