/**
 * @author M4rc Adam
 */
package com.ece.superkids.entities;

import com.ece.superkids.enums.QuestionLevel;


public class State {

    private QuestionLevel currentLevel;
    private Question currentQuestion;
    private Integer numberOfCorrectAnswers;
    private Integer numberOfWrongAnswers;

    public State() {
        numberOfCorrectAnswers = 0;
        numberOfWrongAnswers = 0;
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

    public Integer getNumberOfCorrectAnswers() {
        return numberOfCorrectAnswers;
    }

    public void setNumberOfCorrectAnswers(Integer numberOfCorrectAnswers) {
        this.numberOfCorrectAnswers = numberOfCorrectAnswers;
    }

    public void incrementNumberOfCorrectAnswers() {
        this.numberOfCorrectAnswers++;;
    }

    public Integer getNumberOfWrongAnswers() {
        return numberOfWrongAnswers;
    }

    public void setNumberOfWrongAnswers(Integer numberOfWrongAnswers) {
        this.numberOfWrongAnswers = numberOfWrongAnswers;
    }
    
    public void incrementNumberOfWrongAnswers() {
        this.numberOfWrongAnswers++;
    }


}
