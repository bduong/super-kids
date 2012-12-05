package com.ece.superkids.achievements.entities;

import java.io.Serializable;

/**
 * The <code>Achievement</code> object represents a goal for the player to reach.
 * When the player reaches the given score they unlocked the corresponding prize.
 *
 * @author Ben Duong
 */
public class Achievement implements Serializable{

    private static final long serialVersionUID = 654321654321654321L;

    private int score;
    private String prize;

    /**
     * Create an achievement with a score and prize.
     *
     * @param score the score the achievement is unlocked
     * @param prize the prize unlocked
     */
    public Achievement(int score, String prize) {
        this.score = score;
        this.prize = prize;
    }

    /**
     * Create an achievement with a blank prize.
     *
     * @param score the score the achievement is unlocked
     */
    public Achievement(final int score) {
        this.score = score;
        prize = "";
    }

    /**
     * Returns the score needed to unlock this achievement.
     *
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * Returns the prize unlocked.
     *
     * @return the prize
     */
    public String getPrize() {
        return prize;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Achievement)) {
            return false;
        }

        Achievement achievement2 = (Achievement) obj;

        if(score != achievement2.getScore()) return false;
        if(!prize.equals(achievement2.getPrize())) return false;

        return true;
    }
}
