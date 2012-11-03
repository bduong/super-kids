package com.ece.superkids.users;

import com.ece.superkids.users.entities.User;
import java.util.List;

public interface UserManager {

    public void addUser(User user);

    public void deleteUser(User user);

    public void updateUser(User oldUser, User new1User) ;

    public User getUser(String name);
    
    public List getAllUsers();
}
