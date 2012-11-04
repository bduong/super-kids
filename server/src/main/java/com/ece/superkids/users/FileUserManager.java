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
<<<<<<< HEAD
    public void deleteUser(final String name) {
        fileUserDatabase.deleteUser(name);
=======
    public void deleteUser(final User user) {
        fileUserDatabase.deleteUser(user.getName());;
>>>>>>> 71200f34f2d05431a2ae2cdd485c0f175a76bf15
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
