package com.ece.superkids.users;

import com.ece.superkids.users.entities.User;
import java.util.List;

public interface UserManager {

    public void addUser(User user);
    public void deleteUser(String name);
    public void updateUser(User oldUser, User newUser) ;
    public User getUser(String name);
<<<<<<< HEAD
=======
    
>>>>>>> 71200f34f2d05431a2ae2cdd485c0f175a76bf15
    public List getAllUsers();
}
