package mappers;

import java.util.List;

import entities.User;

public interface UserMapper {
    
    public List<User> getUser(User user);

    public Integer reg(User user);

}