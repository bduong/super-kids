/**
 * @author M4rc Adam
 */
package com.ece.superkids.users.entities;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.io.Serializable;

import com.ece.superkids.questions.enums.QuestionLevel;
import com.ece.superkids.questions.entities.Question;
import com.ece.superkids.questions.enums.QuestionCategory;

/**
 *
 * @author elm
 */
public class State implements Serializable {

    private QuestionLevel currentLevel;
    private Question currentQuestion;
    private QuestionCategory currentCategory;
    private Map<Question, Integer> scores;
    static final long serialVersionUID = -6618469841122132321L;

    /** Contstructor for state.
     */
    public State() {
        scores = new HashMap<Question, Integer>();
    }
    
    public QuestionCategory getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(QuestionCategory currentCategory) {
        this.currentCategory = currentCategory;
    }

    public QuestionLevel getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(QuestionLevel currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public boolean addScore(Question question, Integer score) {
        if(!scores.containsKey(question)) {
            scores.put(question, score);
            return true;
        } else {
            return false;
        }
    }

    public Integer getTotalScore() {
        Integer score = 0;
        Iterator it = scores.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            score += scores.get(pairs.getKey());
        }
        return score;
    }

    public Map<Question, Integer> getScores(int scoreLevel) {
        Map<Question, Integer> score = new HashMap<Question, Integer>();
        Iterator it = scores.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            if(scores.get(pairs.getKey()).equals(scoreLevel)) {
                score.put((Question)pairs.getKey(), (Integer)pairs.getValue());
            }
        }
        return score;
    }

    public Map<Question, Integer> getAllScores() {
        return scores;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof State)) {
           return false;
        }
        
        State state = (State)object;
        if(!(currentQuestion == state.currentQuestion)) return false;
        if (!(currentLevel == state.currentLevel))  return false;
        if (!currentCategory.equals(state.currentCategory))  return false;

        return true;
    }
    
}
