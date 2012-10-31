package com.ece.superkids.questions.entities;

import com.ece.superkids.questions.enums.QuestionCategory;
import com.ece.superkids.questions.enums.QuestionLevel;
import com.ece.superkids.questions.enums.QuestionType;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private String question;
    private List<String> choices;
    private String answer;
    private String explaination;
    private QuestionType type;
    private QuestionCategory category;
    private QuestionLevel level;

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

    public String getExplaination() {
        return explaination;
    }

    public void setExplaination(final String explaination) {
        this.explaination = explaination;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(final QuestionType type) {
        this.type = type;
    }

    public QuestionCategory getCategory() {
        return category;
    }

    public void setCategory(final QuestionCategory category) {
        this.category = category;
    }

    public QuestionLevel getLevel() {
        return level;
    }

    public void setLevel(final QuestionLevel level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Question)) {
           return false;
        }
        Question quest2 = (Question) obj;

        if (!question.equals(quest2.question)) return false;
        if (!choices.equals(quest2.choices)) return false;
        if (!answer.equals(quest2.answer)) return false;
        if (!explaination.equals(quest2.explaination))  return false;
        if (!type.equals(quest2.type))  return false;
        if (!category.equals(quest2.category)) return false;
        if (!level.equals(quest2.level)) return false;

        return true;
    }
}
