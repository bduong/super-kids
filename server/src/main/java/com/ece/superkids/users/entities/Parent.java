package com.ece.superkids.users.entities;

import java.util.ArrayList;

/**
 * The <code>Parent</code> class represents the parent of the kids playing the game.
 * It holds a list of users, and function to add users and delete users.
 *
 * @author Marc Adam
 */
public class Parent {
    private ArrayList<User> users;

    /**
     * Create a new parent object.
     */
    public Parent() {
        users = new ArrayList();
    }

    /**
     * Get the list of users.
     * @return List of users.
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Add a user to the list of users.
     * @param name Name of the user to be added.
     * @return User added successfully.
     */
    public boolean addUser(String name) {
        User user = new User(name);
        if(!users.contains(user)) {
            users.add(user);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Remove the user from the list of users.
     * @param name Name of the user to be removed.
     * @return User removed successfully.
     */
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
