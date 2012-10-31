/**
 * @author M4rc Adam
 */
package com.ece.superkids.entities;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

import com.ece.superkids.enums.QuestionLevel;

public class State {

    private QuestionLevel currentLevel;
    private Question currentQuestion;
    private Map<Question, Integer> scores;

    public State() {
        scores = new HashMap<Question, Integer>();
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








}
