package com.ece.superkids.users.builders;

import com.ece.superkids.achievements.entities.Achievements;
import com.ece.superkids.users.entities.History;
import com.ece.superkids.users.entities.State;
import com.ece.superkids.users.entities.User;

public class UserBuilder {

    private int id;
    private String name;
    private State state;
    private History history;
    private String image;
    private Achievements achievements;

    public static UserBuilder aUser() {
        return new UserBuilder();
    }

    public UserBuilder copiedFrom(User user) {
        id = user.getId();
        name = user.getName();
        state = user.getState();
        history = user.getHistory();
        image = user.getImage();
        achievements = AchievementsBuilder.aSetOfAchievements()
                .copiedFrom(user.getAchievements())
                .build();
        return this;
    }

    public UserBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public UserBuilder named(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder withSate(State state) {
        this.state = state;
        return this;
    }

    public UserBuilder withHistory(History history) {
        this.history = history;
        return this;
    }

    public UserBuilder withImage(String image) {
        this.image = image;
        return this;
    }

    public UserBuilder withAchievements(Achievements achievements) {
        this.achievements = achievements;
        return this;
    }

    public User build() {
        User user = new User(name);
        user.setId(id);
        user.setImage(image);
        if (state != null) user.copyState(state);
        if (history != null) user.setHistory(history);
        if (achievements != null) user.setAchievements(achievements);

        return user;
    }
}
