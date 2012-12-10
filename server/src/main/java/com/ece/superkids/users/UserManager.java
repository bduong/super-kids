package com.ece.superkids.users;

import com.ece.superkids.users.entities.User;
import java.util.List;

/**
 * The <code>UserManager</code> class is an interface for the UserDatabase class.
 * It has functions to add, delete, update and get users.
 *
 * @author Marc Adam
 */
public interface UserManager {

    /**
     * Add a user to the database
     *
     * @param user User object representing the user to be added.
     */
    public void addUser(User user);

    /**
     * Delete a user from the database.
     *
     * @param name Name of the user to be deleted.
     */
    public void deleteUser(String name);

    /**
     * Update the user in the database.
     *
     * @param oldUser User to update.
     * @param newUser User to be updated to.
     */
    public void updateUser(User oldUser, User newUser) ;

    /**
     * Get the user object from the database
     * @param name Name of the user to get.
     * @return User returned.
     */
    public User getUser(String name);

    /**
     * Get all the users in the database.
     * 
     * @return List of users in the database.
     */
    public List getAllUsers();
}
