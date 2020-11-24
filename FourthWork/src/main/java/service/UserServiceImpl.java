package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.User;
import mappers.UserMapper;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> login(User user) {
        // TODO Auto-generated method stub
        return userMapper.getUser(user);
    }

    public Integer reg(User user) {
        // TODO Auto-generated method stub
        return userMapper.reg(user);
    }

}