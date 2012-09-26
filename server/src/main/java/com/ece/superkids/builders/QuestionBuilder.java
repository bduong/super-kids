package com.ece.superkids.builders;

import com.ece.superkids.entities.Question;
import com.ece.superkids.enums.QuestionType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionBuilder {

    private String question;
    private List<String> choices;
    private String answer;
    private String explaination;
    private QuestionType type;

    private QuestionBuilder() {}

    public static QuestionBuilder aQuestion() {
        return new QuestionBuilder();
    }

    public QuestionBuilder asking(String question) {
        this.question = question;
        return this;
    }

    public QuestionBuilder withChoices(String ... choices) {
        this.choices = new ArrayList<String>();
        Collections.addAll(this.choices, choices);
        return this;
    }

    public QuestionBuilder withAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    public QuestionBuilder withExplaination(String explaination) {
        this.explaination = explaination;
        return this;
    }

    public QuestionBuilder ofType(QuestionType type) {
        this.type = type;
        return this;
    }

    public Question build() {
        Question quest = new Question();
        quest.setQuestion(question);
        quest.setChoices(choices);
        quest.setAnswer(answer);
        quest.setExplaination(explaination);
        quest.setType(type);
        return quest;
    }
}
