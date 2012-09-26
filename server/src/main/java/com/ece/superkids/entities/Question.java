package com.ece.superkids.entities;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private String question;
    private List<String> choices;
    private String answer;

    public Question() {
        choices = new ArrayList<String>();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(final String question) {
        this.question = question;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(final List<String> choices) {
        this.choices = choices;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(final String answer) {
        this.answer = answer;
    }
}
