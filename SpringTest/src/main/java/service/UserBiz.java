package service;

import model.User;

public interface UserBiz {
    public User login(String username, String password);
}