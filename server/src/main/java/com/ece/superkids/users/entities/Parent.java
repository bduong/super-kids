/**
 * @author M4rc Adam
 */
package com.ece.superkids.users.entities;

import java.util.ArrayList;

public class Parent {
    private ArrayList<User> users;

    public Parent() {
        users = new ArrayList();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public boolean addUser(String name) {
        User user = new User(name);
        if(!users.contains(user)) {
            users.add(user);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeUser(String name) {
        for(int i=0; i<users.size(); i++) {
            if(users.get(i).getName().equals(name)) {
                users.remove(i);
                return true;
            }
        }
        return false;
    }


}
