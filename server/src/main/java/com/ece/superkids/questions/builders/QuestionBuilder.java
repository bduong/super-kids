package com.ece.superkids.questions.builders;

import com.ece.superkids.questions.entities.Question;
import com.ece.superkids.questions.enums.QuestionCategory;
import com.ece.superkids.questions.enums.QuestionLevel;
import com.ece.superkids.questions.enums.QuestionType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The <code>QuestionBuilder</code> allows rapid and fluent construction of Question objects.
 *
 * @author Ben Duong
 */
public class QuestionBuilder {

    private String question;
    private List<String> choices;
    private String answer;
    private String explaination;
    private QuestionType type;
    private QuestionCategory category;
    private QuestionLevel level;

    private QuestionBuilder() {}

    /**
     * Create a new question builder.
     *
     * @return The Question builder.
     */
    public static QuestionBuilder aQuestion() {
        return new QuestionBuilder();
    }

    /**
     * Copy all of the fields from a given question.
     *
     * @param ques the question to copy
     * @return This question builder.
     */
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

    /**
     * Set the question string to be asked.
     *
     * @param question the question string
     * @return This question builder.
     */
    public QuestionBuilder asking(String question) {
        this.question = question;
        return this;
    }

    /**
     * Set the choices that the player can pick.
     *
     * @param choices the choices to use
     * @return This question builder.
     */
    public QuestionBuilder withChoices(String ... choices) {
        this.choices = new ArrayList<String>();
        Collections.addAll(this.choices, choices);
        return this;
    }

    /**
     * Set the answer to the question.
     *
     * @param answer the question answer
     * @return This question builder.
     */
    public QuestionBuilder withAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    /**
     * Set the explanation of the answer.
     *
     * @param explaination the explanation
     * @return This question builder.
     */
    public QuestionBuilder withExplaination(String explaination) {
        this.explaination = explaination;
        return this;
    }

    /**
     * Set the type of question.
     *
     * @param type the question type
     * @return This question builder.
     */
    public QuestionBuilder ofType(QuestionType type) {
        this.type = type;
        return this;
    }

    /**
     * Set the level of the question.
     *
     * @param level the question level
     * @return This question builder.
     */
    public QuestionBuilder ofLevel(QuestionLevel level) {
        this.level = level;
        return this;
    }

    /**
     * Set the category of the question.
     *
     * @param category the question category
     * @return This question builder.
     */
    public QuestionBuilder inCategory(QuestionCategory category) {
        this.category = category;
        return this;
    }

    /**
     * Build the question from the set fields.
     *
     * @return The constructed question.
     */
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
