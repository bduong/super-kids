package com.ece.superkids.users;

public interface ParentManager {

    boolean doesParentExist();

    boolean checkParentPassword(String password);

    boolean changeParentPassword(String newPass);

    void deleteParentAccount(boolean wait);
}
