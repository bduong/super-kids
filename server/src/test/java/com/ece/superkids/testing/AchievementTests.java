package com.ece.superkids.testing;

import com.ece.superkids.achievements.entities.Achievement;
import com.ece.superkids.achievements.entities.Achievements;
import com.ece.superkids.users.entities.User;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class AchievementTests {

    private Achievements achievements;
    private Achievement achievementOne;
    private Achievement achievementTwo;


    @Before
    public void setup() {
        achievements = new Achievements();
        achievementOne = new Achievement(10, "Ice Cream");
        achievementTwo = new Achievement(20, "New Toy");
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
}
