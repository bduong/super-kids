package com.ece.superkids.users;

import com.ece.superkids.users.entities.User;
import com.google.gson.Gson;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileUserDatabase  implements UserDatabase {
  private static final String FILE_NAME_USER = "/Users.txt";
  private Gson gson;
  private Map<String, User> users;

  public FileUserDatabase() {
      gson = new Gson();
      users = new HashMap<String, User>();
  }

  private void loadUsersFromFile(String fileName) {
      users = new HashMap<String, User>();
      InputStream in = getClass().getResourceAsStream(fileName);
      try {
          BufferedReader reader = new BufferedReader(new InputStreamReader(in));
          while (true) {
              String line = reader.readLine();
              if (line == null) {
                  break;
              }
              User user = gson.fromJson(line, User.class);
              String name = user.getName();
              users.put(name, user);
          }
      } catch(Exception e) {

      }
  }

  public boolean saveUser(String name) {
      User user = new User(name);
      if(!users.containsKey(name)) {
          File file = new File(getClass().getResource("/" + FILE_NAME_USER).getFile());
          try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(gson.toJson(user));
            writer.write('\n');
            writer.close();

            users.put(name, user);
          } catch(Exception e) {
              // e.printStackTrace();
              System.out.println("Error saving user to file");
              return false;
          }
          return true;
      } else {
          return false;
      }
  }

  public User getUser(String name) {
      if(users.containsKey(name)) {
          return users.get(name);
      } else {
          return null;
      }
  }

  public Map<String, User> getUsers() {
      return users;
  }

}
