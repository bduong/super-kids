package com.ece.superkids.users;

import com.ece.superkids.FileManagerImpl;
import com.ece.superkids.users.entities.User;
import java.io.*;
import java.util.ArrayList;

/**
 * The <code>FileUserDatabase</code> class implements for the UserDatabase class.
 * It implements the functions to add, delete, update and get users by serializing/deserializing files from the database.
 *
 * @author Marc Adam
 */
public class FileUserDatabase  implements UserDatabase {

    String userHome;
    String path;
    
    /**
     * Create a FileUserDatabase object and set the path to .superkidsdata
     */
    public FileUserDatabase() {
        userHome = FileManagerImpl.getInstance().getDirectory().getAbsolutePath();
        path = userHome+File.separator;
    }

    /**
     * Construct a user object from a serialized file.
     * @param filename Path for the serialized file.
     * @return User object deserialized.
     */
    private User getUserFromFile(String filename) {

      try {
          ObjectInputStream input = new ObjectInputStream(new FileInputStream(path + filename));
          User user = (User)input.readObject();
          input.close();
          return user;

      } catch(IOException e) {
          return null;
      } catch (ClassNotFoundException e) {
          e.printStackTrace();
      }

      return null;
  }

  /**
   * Save the user to a file using serialization. The user is saved in name.ser
   * @param user User to be saved in the file.
   */
  public void saveUser(User user) {
      String filename = user.getName() + ".ser";
      try {
          FileOutputStream file = new FileOutputStream(path+filename);
          BufferedOutputStream buffer = new BufferedOutputStream( file );
          ObjectOutputStream output = new ObjectOutputStream( buffer );
          try {
              output.writeObject(user);
          } finally {
              output.close();
          }

      } catch(Exception e) {
          System.out.println("Could not serialize user: " + user.getName());
          e.printStackTrace();
      }
  }

  /**
   * Get the user from a file by deserializing the file.
   * @param name Name of the user to get.
   * @return User object deserialized.
   */
  public User getUser(String name) {
      String filename = name + ".ser";
      return getUserFromFile(filename);
  }

  /**
   * Delete the file for the user.
   * @param name Name of the user.
   * @return File deleted successfully.
   */
  public boolean deleteUser(String name) {
      File file = new File(path+name+".ser");
      return file.delete();
  }

  /**
   * Update the serialized file of the user.
   * @param oldUser User to update.
   * @param newUser User to be updated to.
   */
  public void updateUser(User oldUser, User newUser) {
      String fileName = path+oldUser.getName() + ".ser";
      String newFileName = path+newUser.getName() + ".ser";
      deleteUser(oldUser.getName());
      saveUser(newUser);
  }

  /**
   * Get all the users in the database, deserialize all files in .superkidsdata.
   * @return List of users.
   */
  public ArrayList<User> getAllUsers() {
      File dir = new File(path);
      File[] files = dir.listFiles(new FilenameFilter() {
          public boolean accept(File dir, String name) {
              return name.toLowerCase().endsWith(".ser");
          }
      });
      ArrayList<User> users = new ArrayList();
      for(int i=0; i<files.length; i++) {
          users.add(getUserFromFile(files[i].getName()));
      }
      return users;
  }

}
