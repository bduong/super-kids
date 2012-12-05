package com.ece.superkids.questions;

import com.ece.superkids.questions.entities.Question;

/**
 * The <code>QuestionManager</code> allows the addition and deletion of custom questions to be
 * used by the game.
 *
 * @author Ben Duong
 */
public interface QuestionManager {

    /**
     * Add a new custom question.
     *
     * @param question the question to add
     */
    public void addQuestion(Question question);

    /**
     * Delete a custom question.
     *
     * Default questions are not allowed to be deleted.
     *
     * @param question the question to delete
     */
    public void deleteQuestion(Question question);

    /**
     * Edit a question.
     *
     * Default questions are not allowed to be editted.
     *
     * @param oldQuestion the old question to edit
     * @param newQuestion the new question to replace it
     */
    public void editQuestion(Question oldQuestion, Question newQuestion);
}
