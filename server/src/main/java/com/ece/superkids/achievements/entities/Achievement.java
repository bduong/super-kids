package com.ece.superkids.achievements.entities;

import java.io.Serializable;

public class Achievement implements Serializable{

    private static final long serialVersionUID = 654321654321654321L;

    private int score;
    private String prize;

    public Achievement(int score, String prize) {
        this.score = score;
        this.prize = prize;
    }

    public Achievement(final int score) {
        this.score = score;
        prize = "";
    }

    public int getScore() {
        return score;
    }

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
