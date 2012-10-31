package com.ece.superkids.questions.builders;

import com.ece.superkids.questions.entities.Question;
import com.ece.superkids.questions.enums.QuestionCategory;
import com.ece.superkids.questions.enums.QuestionLevel;
import com.ece.superkids.questions.enums.QuestionType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionBuilder {

    private String question;
    private List<String> choices;
    private String answer;
    private String explaination;
    private QuestionType type;
    private QuestionCategory category;
    private QuestionLevel level;

    private QuestionBuilder() {}

    public static QuestionBuilder aQuestion() {
        return new QuestionBuilder();
    }

    public QuestionBuilder copiedFrom(Question ques) {
        question = ques.getQuestion();
        choices = ques.getChoices();
        answer = ques.getAnswer();
        explaination = ques.getExplaination();
        type = ques.getType();
        category = ques.getCategory();
        level = ques.getLevel();
        return this;
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

    public QuestionBuilder ofLevel(QuestionLevel level) {
        this.level = level;
        return this;
    }

    public QuestionBuilder inCategory(QuestionCategory category) {
        this.category = category;
        return this;
    }

    public Question build() {
        Question quest = new Question();
        quest.setQuestion(question);
        quest.setChoices(choices);
        quest.setAnswer(answer);
        quest.setExplaination(explaination);
        quest.setType(type);
        quest.setCategory(category);
        quest.setLevel(level);
        return quest;
    }
}
