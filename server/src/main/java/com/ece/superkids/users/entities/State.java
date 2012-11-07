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

    private Question currentQuestion;
    private Map<Question, Integer> scores;
    static final long serialVersionUID = -6618469841122132321L;

    /** Contstructor for state.
     */
    public State() {
        scores = new HashMap<Question, Integer>();
    }
    
    public QuestionCategory getCurrentCategory() {
        return currentQuestion.getCategory();
    }

    public QuestionLevel getCurrentLevel() {
        return currentQuestion.getLevel();
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

        return true;
    }
    
}
