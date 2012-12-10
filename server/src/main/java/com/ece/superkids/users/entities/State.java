package com.ece.superkids.users.entities;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.io.Serializable;

import com.ece.superkids.questions.enums.QuestionLevel;
import com.ece.superkids.questions.entities.Question;
import com.ece.superkids.questions.enums.QuestionCategory;

/**
 * The <code>State</code> class represents the current state of the user.
 * It holds all the information for current level, category, and scores map from questions to scores.
 *
 * @author Marc Adam
 */
public class State implements Serializable {

    static final long serialVersionUID = 1L;

    private QuestionLevel currentLevel;
    private Question currentQuestion;
    private QuestionCategory currentCategory;

    
    private Map<Question, Integer> scores;

    /**
     * Create a new State object.
     */
    public State() {
        scores = new HashMap<Question, Integer>();
    }

    /**
     * Get the current category.
     * Use this for continue game.
     * @return User's current category.
     */
    public QuestionCategory getCurrentCategory() {
        return currentCategory;
    }
    /**
     * Set the current category for the user.
     * @param currentCategory Current category to set for the user.
     */
    public void setCurrentCategory(QuestionCategory currentCategory) {
        this.currentCategory = currentCategory;
    }

    /**
     * Get the current level of the user.
     * @return Current level of the user.
     */
    public QuestionLevel getCurrentLevel() {
        return currentLevel;
    }
    /**
     * Set the current level for the user.
     * @param currentLevel Current level to set for the user.
     */
    public void setCurrentLevel(QuestionLevel currentLevel) {
        this.currentLevel = currentLevel;
    }

    /**
     * Get the question the user is currently playing.
     * Use this for resuming game.
     * @return Current question the user is playing.
     */
    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    /**
     * Set the current question for the user.
     * @param currentQuestion Question to be set as current.
     */
    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    /**
     * Save the question with the score in the scores map.
     * Call this whenever the user is done answering a question.
     * @param question Question the user just answered.
     * @param score Score of the question the user just answered.
     * @return Score saved successfully
     */
    public boolean addScore(Question question, Integer score) {
        if(!scores.containsKey(question)) {
            scores.put(question, score);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get the score of the current level and category.
     * @return Current level and category total score.
     */
    public Integer getTotalScore() {
        Integer score = 0;
        Iterator it = scores.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            score += scores.get(pairs.getKey());
        }
        return score;
    }

    /**
     * Get All the questions with a certain score level
     * @param scoreLevel Score level of the questions
     * @return A map from questions to scores
     */
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


    /**
     * Checks if two State objects are the same.
     * @param object State to check on.
     * @return Both states are the same.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof State)) {
           return false;
        }
        
        State state = (State)object;
        if(!currentQuestion.equals(state.currentQuestion)) return false;
        if (!currentLevel.equals(state.currentLevel))  return false;
        if (!currentCategory.equals(state.currentCategory))  return false;

        return true;
    }
    
}
