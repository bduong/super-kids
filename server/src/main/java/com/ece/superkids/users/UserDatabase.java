package com.ece.superkids.users;

import com.ece.superkids.users.entities.User;
import java.util.ArrayList;

public interface UserDatabase {

    public User getUser(String name);
    public ArrayList<User> getAllUsers();
    public void saveUser(User user);
    public void updateUser(User oldUser, User newUser);
    public boolean deleteUser(String name);

}
