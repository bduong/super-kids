package com.ece.superkids.users;

import com.ece.superkids.users.entities.User;
import java.util.List;

/**
 * The <code>FileUserManager</code> class is an interface for the UserManager class.
 * It has functions to add, delete, update and get users.
 *
 * @author Marc Adam
 */
public class FileUserManager implements UserManager {

    FileUserDatabase fileUserDatabase = new FileUserDatabase();

    /**
     * Add a user to the database
     *
     * @param user User object representing the user to be added.
     */
    @Override
    public void addUser(final User user) {
        fileUserDatabase.saveUser(user);
    }
    
    /**
     * Delete a user from the database.
     *
     * @param name Name of the user to be deleted.
     */
    @Override
    public void deleteUser(final String name) {
        fileUserDatabase.deleteUser(name);
    }

    /**
     * Update the user in the database.
     *
     * @param oldUser User to update.
     * @param newUser User to be updated to.
     */
    @Override
    public void updateUser(final User oldUser, final User newUser) {
        fileUserDatabase.updateUser(oldUser, newUser);
    }
    
    /**
     * Get the user object from the database
     * @param name Name of the user to get.
     * @return User returned.
     */
    @Override
    public User getUser(final String name) {
        User returnUser = fileUserDatabase.getUser(name);
        return returnUser;
    }

    /**
     * Get all the users in the database.
     *
     * @return List of users in the database.
     */
    @Override
    public List getAllUsers() {
        List listUsers = fileUserDatabase.getAllUsers();
        return listUsers;
    }
}
