/**
 * @author M4rc Adam
 */
package com.ece.superkids.users.entities;

import com.ece.superkids.questions.entities.Question;
import com.ece.superkids.questions.enums.QuestionCategory;
import com.ece.superkids.questions.enums.QuestionLevel;
import com.ece.superkids.users.UserDatabaseFactory;
import com.ece.superkids.users.FileUserManager;
import com.ece.superkids.users.UserManager;
import java.io.Serializable;

public class User implements Serializable {

    static final long serialVersionUID = -6618469841127325812L;

    private int id;
    private String name;
    private State state;
    private History history;

    public User(String name) {
        this.name = name;
        state = new State();
        history = new History();
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

    private void setState(State state) {
        this.state = state;
        saveUser();
    }
    
    public void setGameOn(boolean set){
        this.history.setGameOn(set);
        saveUser();
    }

    public boolean isGameOn() {
        return history.getGameOn();
    }
    
    public boolean isCurrentLevelFinished(){
        return history.isLevelFinished(this.state.getCurrentLevel());
    }

    public void setCurrentQuestion(Question question) {
        history.setGameOn(true);
        state.setCurrentQuestion(question);
        state.setCurrentLevel(question.getLevel());
        state.setCurrentCategory(question.getCategory());
        saveUser();
    }

    public void saveScore(Question question, Integer score) {
        state.addScore(question, score);
    }

    public void endState() {
        //category is finished
        state.categoryFinished();
        history.saveToHistory(state);
        saveUser();
    }

    public void newState(QuestionCategory category, QuestionLevel level) {
        state = new State();
        state.setCurrentCategory(category);
        state.setCurrentLevel(level);
        saveUser();
    }

    public void saveUser() {
        (new FileUserManager()).addUser(this);
        (new FileUserManager()).updateUser(this, this);
    }

    public Object[][] getHistory(QuestionCategory questionCategory, QuestionLevel questionLevel) {
        return history.getHistory(questionCategory, questionLevel);
    }

    public Object[][] getHistoryTest() {
        return history.getHistoryTest();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User)) {
           return false;
        }
        User user2 = (User)obj;
        if (!(id == user2.id))  return false;
        if (!name.equals(user2.name))  return false;

        return true;
    }





}

