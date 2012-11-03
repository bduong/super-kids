/**
 * @author M4rc Adam
 */
package com.ece.superkids.users.entities;

import com.ece.superkids.questions.entities.Question;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String name;
    private State state;
    // private History history;

    public User(String name) {
        this.name = name;
        state = new State();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void addScore(Question question, Integer score) {
        state.addScore(question, score);
    }
}
