package com.ece.superkids.achievements.entities;

import java.io.Serializable;
import java.util.*;

/**
 * The <code>Achievements</code> object is an encapsulation of multiple achievements.
 *
 * @author Ben Duong
 */
public class Achievements implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Achievement> achievements;

    /**
     * Create a new list of 10 blank achievements with scores from 10-100 in steps of 10.
     */
    public Achievements() {
        achievements = new ArrayList<Achievement>();
        for (int ii = 10; ii < 110; ii+=10){
            achievements.add(new Achievement(ii));
        }
    }

    /**
     * Get an achievement in the list.
     *
     * @param number the index of the achievement
     * @return The achievement at that index.
     */
    public Achievement getAchievement(int number) {
        return achievements.get(number);
    }

    /**
     * Get the achievements that have been unlocked in this game.
     *
     * Achievements that are unlocked are removed from the list.
     *
     * @param totalScore the new total score the child has gotten.
     * @return A list of achievements that the child has unlocked.
     */
    public List<Achievement> getAchievementsUnlocked(int totalScore) {
        List<Achievement> unlocked = new ArrayList<Achievement>();
        int lastScore = achievements.get(9).getScore();
        for (Achievement achievement : achievements) {
            if (achievement.getScore() <= totalScore) {
                unlocked.add(achievement);
            } else {
                break;
            }
        }

        achievements.removeAll(unlocked);
        int readd = 10 - achievements.size();
        for (int ii = 0; ii < readd; ii++) {
            lastScore+=10;
            achievements.add(new Achievement(lastScore));
        }

        return unlocked;
    }

    /**
     * Change an achievement.
     *
     * Achievements are then sorted by score.
     *
     * @param index the index of the achievement to change
     * @param newAchievement the new achievement to use
     */
    public void changeAchievement(int index, Achievement newAchievement) {
        achievements.set(index, newAchievement);
        Collections.sort(achievements, COMPARATOR);
    }

    private static Comparator<Achievement> COMPARATOR = new Comparator<Achievement>() {
        @Override
        public int compare(final Achievement o1, final Achievement o2) {
            return o1.getScore() - o2.getScore();
        }
    };
}
