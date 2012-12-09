package com.ece.superkids.users;

import com.ece.superkids.users.entities.RecoveryQuestion;

/**
 * The <code>ParentManager</code> allows interactions as a parent user.
 *
 * @author Ben Duong
 */
public interface ParentManager {

    /**
     * Checks for the existence of a parent account.
     *
     * @return True if the parent user exists, false otherwise.
     */
    boolean doesParentExist();

    /**
     * Check a password against the stored parent password.
     *
     * @param password the password to check
     * @return True if the passwords match, false otherwise.
     */
    boolean checkParentPassword(String password);

    /**
     * Change the parent password.
     *
     * @param newPass the new password to use.
     * @return True if successful, false otherwise
     */
    boolean changeParentPassword(String newPass);

    /**
     * Delete the parent account.
     *
     * @param wait true if immediate action, false if wait until exit of application
     */
    void deleteParentAccount(boolean wait);

    boolean setRecoverQuestion(RecoveryQuestion question);

    RecoveryQuestion getRecoveryQuestion();
}
