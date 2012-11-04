package com.ece.superkids.users;


public class UserDatabaseFactory {

    private static UserDatabase userDatabase;
    private static UserManager userManager;
    private static ParentManager parentManager;

    public static UserDatabase aUserDatabase() {
        if(userDatabase == null) {
            userDatabase = new FileUserDatabase();
        }
        return userDatabase;
    }

    public static UserManager aUserManager() {
        if (userManager == null) {
            userManager = new FileUserManager();
        }
        return userManager;
    }

    public static ParentManager aParentManager() {
        if (parentManager == null) {
            parentManager = new FileParentManager();
        }
        return parentManager;
    }

}
