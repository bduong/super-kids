package com.ece.superkids.users;

import com.ece.superkids.users.entities.User;
import java.util.ArrayList;

/**
 * The <code>UserDatabase</code> class is an interface for  for the FileUserDatabase class.
 * It has functions to add, delete, update and get users by serializing/deserializing files from the database.
 *
 * @author Marc Adam
 */
public interface UserDatabase {

  /**
   * Get the user from a file by deserializing the file.
   * @param name Name of the user to get.
   * @return User object deserialized.
   */
    public User getUser(String name);

  /**
   * Get all the users in the database, deserialize all files in .superkidsdata.
   * @return List of users.
   */
    public ArrayList<User> getAllUsers();

  /**
   * Save the user to a file using serialization. The user is saved in name.ser
   * @param user User to be saved in the file.
   */
    public void saveUser(User user);

  /**
   * Update the serialized file of the user.
   * @param oldUser User to update.
   * @param newUser User to be updated to.
   */
    public void updateUser(User oldUser, User newUser);

  /**
   * Delete the file for the user.
   * @param name Name of the user.
   * @return File deleted successfully.
   */
    public boolean deleteUser(String name);

}
