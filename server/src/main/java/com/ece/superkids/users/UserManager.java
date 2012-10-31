package com.ece.superkids.users;

import com.ece.superkids.users.entities.User;

public interface UserManager {

    public void addUser(User user);

    public void deleteUser(User user);

    public void editUser(User oldUser, User newUser) ;
}
