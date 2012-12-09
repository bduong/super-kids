package com.ece.superkids.users.builders;

import com.ece.superkids.achievements.entities.Achievement;

public class AchievementBuilder {

    private int score;
    private String prize;

    public static AchievementBuilder anAchievement() {
        return new AchievementBuilder();
    }

    public AchievementBuilder copiedFrom(Achievement copy) {
        score = copy.getScore();
        prize = copy.getPrize();
        return this;
    }

    public AchievementBuilder unlockedAt(int score) {
        this.score = score;
        return this;
    }

    public AchievementBuilder withPrize(String prize) {
        this.prize = prize;
        return this;
    }

    public Achievement build() {
        return new Achievement(score, prize);
    }
}
