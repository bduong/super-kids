package com.ece.superkids.users;

import com.ece.superkids.users.entities.User;

import java.io.*;
import java.util.ArrayList;

public class FileUserDatabase  implements UserDatabase {

    String userHome;

  public FileUserDatabase() {
      userHome = System.getProperty( "user.home" );
  }

  private User getUserFromFile(String filename) {
      User user = null;
      try {
          InputStream file = new FileInputStream(filename);
          InputStream buffer = new BufferedInputStream( file );
          ObjectInput input = new ObjectInputStream ( buffer );
          try {
              user = (User)input.readObject();
          } finally {
              input.close();
          }
      } catch(Exception e) {
          System.out.println("Could not deserialize file: " + filename);
          e.printStackTrace();
      } finally {
          return user;
      }
  }

  // serialize the user
  public void saveUser(User user) {
      String filename = user.getName() + ".ser";
      try {
          OutputStream file = new FileOutputStream(filename);
          OutputStream buffer = new BufferedOutputStream( file );
          ObjectOutput output = new ObjectOutputStream( buffer );
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
      User user = null;
      try {
          InputStream file = new FileInputStream(filename);
          InputStream buffer = new BufferedInputStream( file );
          ObjectInput input = new ObjectInputStream ( buffer );
          try {
              user = (User)input.readObject();
          } finally {
              input.close();
          }
      } catch(Exception e) {
          System.out.println("Could not deserialize file: " + filename);
          e.printStackTrace();
      } finally {
          return user;
      }
  }

  // delete user object file
  public boolean deleteUser(String name) {
      File file = new File(name+".ser");
      return file.delete();
  }

  // update user object file
  public void updateUser(User oldUser, User newUser) {
      String fileName = oldUser.getName() + ".ser";
      String newFileName = newUser.getName() + ".ser";
      deleteUser(oldUser.getName());
      saveUser(newUser);
  }

  public ArrayList<User> getAllUsers() {
      File dir = new File(userHome);
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
