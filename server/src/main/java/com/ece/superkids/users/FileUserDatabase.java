package com.ece.superkids.users;

import com.ece.superkids.users.entities.User;

import java.io.*;

public class FileUserDatabase  implements UserDatabase {

    String userHome;

  public FileUserDatabase() {
      userHome = System.getProperty( "user.home" );
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

}
