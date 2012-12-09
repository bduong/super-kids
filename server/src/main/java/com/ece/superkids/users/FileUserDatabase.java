package com.ece.superkids.users;

import com.ece.superkids.FileManagerImpl;
import com.ece.superkids.users.entities.User;
import java.io.*;
import java.util.ArrayList;

public class FileUserDatabase  implements UserDatabase {

    String userHome;
    String path;

  public FileUserDatabase() {
      userHome = FileManagerImpl.getInstance().getDirectory().getAbsolutePath();
      path = userHome+File.separator;
      //System.out.println(path);
  }

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

  // serialize the user
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

  // deserialize the user
  public User getUser(String name) {
      String filename = name + ".ser";
      return getUserFromFile(filename);
  }

  // delete user object file
  public boolean deleteUser(String name) {
      File file = new File(path+name+".ser");
      return file.delete();
  }

  // update user object file
  public void updateUser(User oldUser, User newUser) {
      String fileName = path+oldUser.getName() + ".ser";
      String newFileName = path+newUser.getName() + ".ser";
      deleteUser(oldUser.getName());
      saveUser(newUser);
  }

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
