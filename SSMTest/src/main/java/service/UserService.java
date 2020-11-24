package service;

import entities.User;

public interface UserService {

    //提供一个getUser服务给SpringMVC的controller
    public User login(User user);
}