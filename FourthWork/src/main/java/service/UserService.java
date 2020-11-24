package service;

import java.util.List;

import entities.User;

public interface UserService {
    
    public List<User> login(User user);

    public Integer reg(User user);

}