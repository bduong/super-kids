package com.ece.superkids.questions;

import com.ece.superkids.questions.entities.Question;
import com.ece.superkids.questions.enums.QuestionCategory;
import com.ece.superkids.questions.enums.QuestionLevel;
import com.ece.superkids.questions.enums.QuestionMode;

/**
 * The <code>QuestionDatabase</code> allows access to the list of questions
 *
 * @author Ben Duong
 */
public interface QuestionDatabase {

    /**
     * Get a question in a given level and category.
     *
     * @param level the question level
     * @param category the question category
     * @param number the question index
     * @return The question of the index in the level and category.
     */
    public Question getQuestion(QuestionLevel level, QuestionCategory category, int number);

    /**
     * Get the number of questions in a given category.
     *
     * @param level the question level
     * @param category the question category
     * @return The number of questions stored in the database in the given category
     */
	public int getNumberOfQuestions(QuestionLevel level, QuestionCategory category);

    /**
     * Get the total number of questions in a given level.
     *
     * @param level the question level
     * @return The number of questions loaded that are in the given level
     */
	public int getNumberOfQuestions(QuestionLevel level);

    /**
     * Load a different set of questions.
     *
     * @param mode the mode to reload the database in
     */
    public void switchMode(QuestionMode mode);

    /**
     * Get the index of a given question.
     *
     * @param question the question
     * @return The index of the question in its level and category. -1 if not found.
     */
    public int getQuestionNumber(Question question);
}
