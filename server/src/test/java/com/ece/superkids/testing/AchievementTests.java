package com.ece.superkids.testing;

import com.ece.superkids.achievements.entities.Achievement;
import com.ece.superkids.achievements.entities.Achievements;
import com.ece.superkids.users.UserDatabaseFactory;
import com.ece.superkids.users.UserManager;
import com.ece.superkids.users.builders.UserBuilder;
import com.ece.superkids.users.entities.User;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class AchievementTests {

    private static final int NUMBER_OF_ACHIEVEMENTS = 10;

    private Achievements achievements;
    private Achievement achievementOne;
    private Achievement achievementTwo;

    private UserManager userManager;


    @Before
    public void setup() {
        achievements = new Achievements();
        achievementOne = new Achievement(10, "Ice Cream");
        achievementTwo = new Achievement(20, "New Toy");
        userManager = UserDatabaseFactory.aUserManager();
    }


    @Test
    public void canUnlockedAchievement() {
        achievements.changeAchievement(0, achievementOne);
        achievements.changeAchievement(1, achievementTwo);

        assertEquals(achievements.getAchievement(0), achievementOne);
        assertEquals(achievements.getAchievement(1), achievementTwo);

        List<Achievement> unlocked = achievements.getAchievementsUnlocked(10);

        assertTrue(unlocked.contains(achievementOne));

        assertEquals(achievements.getAchievement(0), achievementTwo);
    }

    @Test
    public void achievementsGetSorted() {
        achievements.getAchievementsUnlocked(20);

        achievements.changeAchievement(7, achievementOne);
        achievements.changeAchievement(5, achievementTwo);
        achievements.sortAchievements();

        assertEquals(achievements.getAchievement(0), achievementOne);
        assertEquals(achievements.getAchievement(1), achievementTwo);
    }

    @Test
    public void achievementsCanBeSaved() throws IOException, ClassNotFoundException {
        achievements.changeAchievement(0, achievementOne);
        achievements.changeAchievement(1, achievementTwo);
        assertEquals(achievements.getAchievement(0), achievementOne);
        assertEquals(achievements.getAchievement(1), achievementTwo);


        File tempFile = File.createTempFile("temp", ".ser");
        tempFile.deleteOnExit();


        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(tempFile));
        output.writeObject(achievements);
        output.close();

        ObjectInputStream input = new ObjectInputStream(new FileInputStream(tempFile));
        Achievements saved = (Achievements) input.readObject();
        input.close();
        assertEquals(saved.getAchievement(0), achievementOne);
        assertEquals(saved.getAchievement(1), achievementTwo);
    }

    @Test
    public void canGetUnlockedAchievements() {
        achievements.changeAchievement(0, achievementOne);
        achievements.changeAchievement(1, achievementTwo);

        List<Achievement> unlocked = achievements.getAchievementsUnlocked(20);

        assertEquals(unlocked.get(0), achievementOne);
        assertEquals(unlocked.get(1), achievementTwo);
    }

    @Test
    public void unlockedAchievementsAreDeleted() {
        achievements.changeAchievement(0, achievementOne);
        achievements.changeAchievement(1, achievementTwo);

        List<Achievement> unlocked = achievements.getAchievementsUnlocked(20);

        assertEquals(unlocked.get(0), achievementOne);
        assertEquals(unlocked.get(1), achievementTwo);

        assertFalse(achievements.getAllAchievements().contains(achievementOne));
        assertFalse(achievements.getAllAchievements().contains(achievementTwo));
        assertEquals(NUMBER_OF_ACHIEVEMENTS, achievements.getAllAchievements().size());
    }

    @Test
    public void canSaveAUser() throws IOException, ClassNotFoundException {
        User user = new User("Me");
        File tempFile = File.createTempFile("temp", ".ser");
        tempFile.deleteOnExit();


        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(tempFile));
        output.writeObject(user);
        output.close();

        ObjectInputStream input = new ObjectInputStream(new FileInputStream(tempFile));
        User save = (User)input.readObject();
        assertEquals(user, save);
    }

    @Test
    public void canSaveUserAchievements() {
        String userName = "tempUser";
        User user = new User(userName);
        userManager.addUser(user);
        User saved = userManager.getUser(userName);

        assertEquals(user, saved);

        achievements.changeAchievement(0, achievementOne);
        achievements.changeAchievement(1, achievementTwo);
        User updateUser = UserBuilder.aUser()
                .copiedFrom(user)
                .build();

        updateUser.setAchievements(achievements);
        userManager.updateUser(user, updateUser);
        User updated = userManager.getUser(userName);

        Achievements savedAchievements = updated.getAchievements();

        assertEquals(savedAchievements.getAchievement(0), achievementOne);
        assertEquals(savedAchievements.getAchievement(1), achievementTwo);
    }
}
