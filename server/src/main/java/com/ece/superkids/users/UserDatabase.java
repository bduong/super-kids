package com.ece.superkids.users;

import com.ece.superkids.users.entities.User;

public interface UserDatabase {

    public User getUser(String name);
    
    public boolean saveUser(String name);

}
