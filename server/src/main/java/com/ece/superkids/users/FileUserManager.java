package com.ece.superkids.users;

import com.ece.superkids.users.entities.User;
import java.util.List;

public class FileUserManager implements UserManager {

    FileUserDatabase fileUserDatabase = new FileUserDatabase();

    @Override
    public void addUser(final User user) {
        fileUserDatabase.saveUser(user);
    }

    @Override
    public void deleteUser(final User user) {
        fileUserDatabase.deleteUser(user.getName());;
    }

    @Override
    public void updateUser(final User oldUser, final User newUser) {
        fileUserDatabase.updateUser(oldUser, newUser);
    }

    @Override
    public User getUser(final String name) {
        User returnUser = fileUserDatabase.getUser(name);
        return returnUser;
    }

    @Override
    public List getAllUsers() {
        List listUsers = fileUserDatabase.getAllUsers();
        return listUsers;
    }
}
