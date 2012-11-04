package com.ece.superkids.testing;

import com.ece.superkids.users.ParentManager;
import com.ece.superkids.users.UserDatabaseFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ParentManagerTests {

    ParentManager parentManager;

    @Before
    public void setup() {
        parentManager = UserDatabaseFactory.aParentManager();
    }

    @After
    public void cleanup() {
        parentManager.deleteParentAccount(false);
    }

    @Test
    public void correctPasswordAllowsParentAccess() {
        String password = "GoodPassword";
        parentManager.changeParentPassword(password);
        assertTrue(parentManager.checkParentPassword(password));
    }

    @Test
    public void incorrectPasswordDoesNotAllowParentAccess() {
        String password = "GoodPassword";
        parentManager.changeParentPassword(password);
        assertFalse(parentManager.checkParentPassword("BadPassword"));
    }
}
