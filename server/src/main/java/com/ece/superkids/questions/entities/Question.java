package com.ece.superkids.questions.entities;

import com.ece.superkids.questions.enums.QuestionCategory;
import com.ece.superkids.questions.enums.QuestionLevel;
import com.ece.superkids.questions.enums.QuestionType;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * The <code>Question</code> object represents a question asked to the player during
 * gameplay.
 *
 * @author Ben Duong
 */
public class Question implements Serializable {
    
    private static final long serialVersionUID = -6618469841127325813L;

    private String question;
    private List<String> choices;
    private String answer;
    private String explaination;
    private QuestionType type;
    private QuestionCategory category;
    private QuestionLevel level;

    /**
     * Create a new empty question.
     */
    public Question() {
        choices = new ArrayList<String>();
    }

    /**
     * Get the question string asked.
     *
     * @return The question string.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Set the question string asked.
     *
     * @param question the question string to use.
     */
    public void setQuestion(final String question) {
        this.question = question;
    }

    /**
     * Get a list of choices available to the player.
     *
     * @return The list of choices.
     */
    public List<String> getChoices() {
        return choices;
    }

    /**
     * Set the list of choices available to the player.
     *
     * @param choices the choices to use
     */
    public void setChoices(final List<String> choices) {
        this.choices = choices;
    }

    /**
     * Get the answer to the question.
     *
     * @return The answer.
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Set the answer to the question.
     *
     * @param answer the answer to use
     */
    public void setAnswer(final String answer) {
        this.answer = answer;
    }

    /**
     * Get the explanation of the answer.
     *
     * @return The explanation.
     */
    public String getExplaination() {
        return explaination;
    }

    /**
     * Set the explanation for the answer.
     *
     * @param explaination the explanation to use
     */
    public void setExplaination(final String explaination) {
        this.explaination = explaination;
    }

    /**
     * Get the type of question.
     *
     * @return The question type.
     */
    public QuestionType getType() {
        return type;
    }

    /**
     * Set the question type.
     *
     * @param type the question type to use
     */
    public void setType(final QuestionType type) {
        this.type = type;
    }

    /**
     * Get the category the question is in.
     *
     * @return The question cateory.
     */
    public QuestionCategory getCategory() {
        return category;
    }

    /**
     * Set the category the question is in.
     *
     * @param category the category to use.
     */
    public void setCategory(final QuestionCategory category) {
        this.category = category;
    }

    /**
     * Get the level the question is in.
     *
     * @return The question level.
     */
    public QuestionLevel getLevel() {
        return level;
    }

    /**
     * SEt the question level.
     *
     * @param level the level to use
     */
    public void setLevel(final QuestionLevel level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null) {
            return false;
        }
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
