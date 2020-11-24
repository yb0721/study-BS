package service.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.User;
import model.dao.UserDao;
import service.UserBiz;

@Service("userBiz")
public class UserBizeImpl implements UserBiz {
    @Autowired
    private UserDao userdao;

    // public void setUserDao(UserDao userdao) {
    //     this.userdao = userdao;
    // }

    public User login(String username, String password) {
        try {
            Thread.sleep(new Random().nextInt(4000));
        } catch (InterruptedException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        
        return userdao.findUser(username, password);
    }
}