package com.ece.superkids.users;

import com.ece.superkids.users.entities.User;

public interface UserDatabase {

    public User getUser(String name);
    public void saveUser(User user);
    public void updateUser(User oldUser, User newUser);
    public boolean deleteUser(String name);

}
