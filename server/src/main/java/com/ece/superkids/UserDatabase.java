package com.ece.superkids;

import com.ece.superkids.entities.User;

public interface UserDatabase {

    public User getUser(String name);
    
    public boolean saveUser(String name);

}
