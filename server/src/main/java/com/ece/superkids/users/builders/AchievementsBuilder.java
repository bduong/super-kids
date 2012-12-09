package com.ece.superkids.users.builders;

import com.ece.superkids.achievements.entities.Achievement;
import com.ece.superkids.achievements.entities.Achievements;

import java.util.ArrayList;
import java.util.List;

public class AchievementsBuilder {

    private List<Achievement> achievements = new ArrayList<Achievement>();

    public static AchievementsBuilder aSetOfAchievements() {
        return new AchievementsBuilder();
    }

    public AchievementsBuilder withAchievement(Achievement achievement) {
        achievements.add(achievement);
        return this;
    }

    public AchievementsBuilder copiedFrom(Achievements copy) {
        achievements.clear();
        for (Achievement achievement : copy.getAllAchievements()) {
            achievements.add(AchievementBuilder
                    .anAchievement()
                    .copiedFrom(achievement).build()
            );
        }
        return this;
    }

    public Achievements build() {
        Achievements achieve = new Achievements();
        achieve.setAchievements(achievements);
        return achieve;
    }
}
